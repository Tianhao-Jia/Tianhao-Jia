package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;


/**
 * based on code from csci3130 lab on march 2nd that Dhrumil presented.
 */
public class ViewJobAdapter extends FirebaseRecyclerAdapter<Job, ViewJobAdapter.JobViewHolder> {




    private static ArrayList<JobViewHolder> holderArrayList = new ArrayList<>(10);
    private JobViewHolder holder;
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ViewJobAdapter(@NonNull FirebaseRecyclerOptions<Job> options) {
        super(options);
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_layout, parent, false);

        view.findViewById(R.id.jobLayoutJobTitle);
        view.findViewById(R.id.jobLayoutEmployerEmail);
        view.findViewById(R.id.jobLayoutDescription);
        view.findViewById(R.id.jobLayoutHourlyRate);
        view.findViewById(R.id.jobLayoutLatitude);
        view.findViewById(R.id.jobLayoutLongitude);

        view.findViewById(R.id.jobLayoutApply);
        view.findViewById(R.id.jobLayoutViewOnMap);
        return new JobViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position, @NonNull Job job) {
        holder.jobLayoutDescription.setText("Description: " + job.getDescription());
        holder.jobLayoutEmployerEmail.setText("Email: " + job.getEmployerEmail());
        holder.jobLayoutJobTitle.setText("Job Title: " + job.getJobTitle());
        holder.jobLayoutHourlyRate.setText("Hourly Rate: " + String.valueOf(job.getCompensation()));
        holder.jobLayoutLatitude.setText( "Latitude: " + String.valueOf(job.getLocation().getLatitude()));
        holder.jobLayoutLongitude.setText("Longitude: " + String.valueOf(job.getLocation().getLongitude()));

        holder.jobLayoutApply.setVisibility(View.VISIBLE);
        holder.jobLayoutViewOnMap.setVisibility(View.VISIBLE);

        this.holder = holder;
        holderArrayList.add(holder);
        //if I want to have the buttons do something this is where they need to be implemented



    }


    public void onBindViewHolder(@NonNull JobViewHolder holder, boolean state) {

        //make everything go away
        if (state) {
            holder.jobLayoutDescription.setText("");
            holder.jobLayoutEmployerEmail.setText("");
            holder.jobLayoutJobTitle.setText("");
            holder.jobLayoutHourlyRate.setText("");
            holder.jobLayoutLatitude.setText("");
            holder.jobLayoutLongitude.setText("");
            holder.jobLayoutApply.setVisibility(View.GONE);
            holder.jobLayoutViewOnMap.setVisibility(View.GONE);
        }

        this.holder = holder;
        //if I want to have the buttons do something this is where they need to be implemented


    }

    //citation from lab on march 2nd
    public class JobViewHolder extends RecyclerView.ViewHolder {
        private TextView jobLayoutJobTitle;
        private TextView jobLayoutEmployerEmail;
        private TextView jobLayoutDescription;
        private TextView jobLayoutHourlyRate;
        private TextView jobLayoutLatitude;



        private TextView jobLayoutLongitude;
        private Button jobLayoutApply;
        private Button jobLayoutViewOnMap;
        private Context context;

        public JobViewHolder(@NonNull View itemView) {
            super(itemView);

            jobLayoutJobTitle = itemView.findViewById(R.id.jobLayoutJobTitle);
            jobLayoutEmployerEmail = itemView.findViewById(R.id.jobLayoutEmployerEmail);
            jobLayoutDescription = itemView.findViewById(R.id.jobLayoutDescription);
            jobLayoutHourlyRate = itemView.findViewById(R.id.jobLayoutHourlyRate);
            jobLayoutLatitude = itemView.findViewById(R.id.jobLayoutLatitude);
            jobLayoutLongitude = itemView.findViewById(R.id.jobLayoutLongitude);

            jobLayoutApply = itemView.findViewById(R.id.jobLayoutApply);
            jobLayoutViewOnMap = itemView.findViewById(R.id.jobLayoutViewOnMap);

            context = itemView.getContext();

        }

        public TextView getJobLayoutJobTitle() {
            return jobLayoutJobTitle;
        }

        public void setJobLayoutJobTitle(TextView jobLayoutJobTitle) {
            this.jobLayoutJobTitle = jobLayoutJobTitle;
        }

        public TextView getJobLayoutEmployerEmail() {
            return jobLayoutEmployerEmail;
        }

        public void setJobLayoutEmployerEmail(TextView jobLayoutEmployerEmail) {
            this.jobLayoutEmployerEmail = jobLayoutEmployerEmail;
        }

        public TextView getJobLayoutDescription() {
            return jobLayoutDescription;
        }

        public void setJobLayoutDescription(TextView jobLayoutDescription) {
            this.jobLayoutDescription = jobLayoutDescription;
        }

        public TextView getJobLayoutHourlyRate() {
            return jobLayoutHourlyRate;
        }

        public void setJobLayoutHourlyRate(TextView jobLayoutHourlyRate) {
            this.jobLayoutHourlyRate = jobLayoutHourlyRate;
        }

        public TextView getJobLayoutLatitude() {
            return jobLayoutLatitude;
        }

        public void setJobLayoutLatitude(TextView jobLayoutLatitude) {
            this.jobLayoutLatitude = jobLayoutLatitude;
        }

        public TextView getJobLayoutLongitude() {
            return jobLayoutLongitude;
        }

        public void setJobLayoutLongitude(TextView jobLayoutLongitude) {
            this.jobLayoutLongitude = jobLayoutLongitude;
        }

    }

    public JobViewHolder getHolder() {
        return holder;
    }

    public void setHolder(JobViewHolder holder) {
        this.holder = holder;
    }

    public static ArrayList<JobViewHolder> getHolderArrayList() {
        return holderArrayList;
    }

    public static void setHolderArrayList(ArrayList<JobViewHolder> holderArrayList) {
        ViewJobAdapter.holderArrayList = holderArrayList;
    }
}
