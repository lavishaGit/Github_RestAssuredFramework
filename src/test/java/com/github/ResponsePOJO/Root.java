package com.github.ResponsePOJO;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Root {
	
	
	 @JsonProperty(value="id") 
	    int id;
	 
	    @JsonProperty(value="node_id") 
	    String node_id;
	    
	    @JsonProperty(value="name") 
	    String name;
	    
	    @JsonProperty(value="full_name") 
	    String full_name;
	    
	    @JsonProperty(value="private") 
boolean myprivate;
	    
	    @JsonProperty("default_branch") 
	    
	    String Default_branch;
	    @JsonProperty(value="owner") 
		Owner owner;


@JsonProperty("html_url") 

String html_url;
@JsonProperty("description") 

Object description;
@JsonProperty("fork") 

boolean fork;
@JsonProperty("url") 

String url;
@JsonProperty("forks_url") 
 
String forks_url;
@JsonProperty("keys_url") 

String keys_url;
@JsonProperty("collaborators_url") 

String collaborators_url;
@JsonProperty("teams_url") 

String teams_url;
@JsonProperty("hooks_url") 

String hooks_url;
@JsonProperty("issue_events_url") 

String issue_events_url;
@JsonProperty("events_url") 

String events_url;
@JsonProperty("assignees_url") 

String assignees_url;
@JsonProperty("branches_url") 

String branches_url;
@JsonProperty("tags_url") 

String tags_url;
@JsonProperty("blobs_url") 

String blobs_url;
@JsonProperty("git_tags_url") 

String git_tags_url;
@JsonProperty("git_refs_url") 

String git_refs_url;
@JsonProperty("trees_url") 

String trees_url;
@JsonProperty("statuses_url") 

String statuses_url;
@JsonProperty("languages_url") 

String languages_url;
@JsonProperty("stargazers_url") 

String stargazers_url;
@JsonProperty("contributors_url") 

String contributors_url;
@JsonProperty("subscribers_url") 

String subscribers_url;
@JsonProperty("subscription_url") 

String subscription_url;
@JsonProperty("commits_url") 

String commits_url;
@JsonProperty("git_commits_url") 
 
String git_commits_url;
@JsonProperty("comments_url")  
String comments_url;
@JsonProperty("issue_comment_url") 

String issue_comment_url;
@JsonProperty("contents_url") 

String contents_url;
@JsonProperty("compare_url") 

String compare_url;
@JsonProperty("merges_url") 

String merges_url;
@JsonProperty("archive_url") 

String archive_url;
@JsonProperty("downloads_url") 

String downloads_url;
@JsonProperty("issues_url") 

String issues_url;
@JsonProperty("pulls_url") 

String pulls_url;
@JsonProperty("milestones_url") 

String milestones_url;
@JsonProperty("notifications_url") 

String notifications_url;
@JsonProperty("labels_url") 

String labels_url;
@JsonProperty("releases_url") 

String releases_url;
@JsonProperty("deployments_url") 


String deployments_url;
@JsonProperty("created_at") 
 

Date created_at;
@JsonProperty("updated_at") 

Date updated_at;
@JsonProperty("pushed_at") 

Date pushed_at;
@JsonProperty("git_url") 

String git_url;
@JsonProperty("ssh_url") 

String ssh_url;
@JsonProperty("clone_url") 
 
String clone_url;
@JsonProperty("svn_url") 

String svn_url;
@JsonProperty("homepage") 

Object homepage;
@JsonProperty("size") 

int size;
@JsonProperty("stargazers_count") 

int stargazers_count;
@JsonProperty("watchers_count") 

int watchers_count;
@JsonProperty("language") 

String language;
@JsonProperty("has_issues") 

boolean has_issues;
@JsonProperty("has_projects") 

boolean has_projects;
@JsonProperty("has_downloads") 

boolean has_downloads;
@JsonProperty("has_wiki") 

boolean has_wiki;
@JsonProperty("has_pages") 

boolean has_pages;
@JsonProperty("has_discussions") 

boolean has_discussions;
@JsonProperty("forks_count") 

int forks_count;
@JsonProperty("mirror_url") 

Object mirror_url;
@JsonProperty("archived") 

boolean archived;
@JsonProperty("disabled") 

boolean disabled;
@JsonProperty("open_issues_count") 

int open_issues_count;
@JsonProperty("license") 

Object license;
@JsonProperty("allow_forking") 
 
boolean allow_forking;
@JsonProperty("is_template") 

boolean is_template;
@JsonProperty("web_commit_signoff_required") 

 
boolean web_commit_signoff_required;
@JsonProperty("topics") 

ArrayList<Object> topics;
@JsonProperty("visibility") 

String visibility;
@JsonProperty("forks") 

int forks;
@JsonProperty("open_issues") 
 
int open_issues;
@JsonProperty("watchers") 
 
int watchers;
@JsonProperty("default_branch") 

String default_branch;
@JsonProperty("permissions") 

Permission permissions;
@JsonProperty("temp_clone_token") 

String temp_clone_token;
@JsonProperty("allow_squash_merge") 

boolean allow_squash_merge;
@JsonProperty("allow_merge_commit") 
 
boolean allow_merge_commit;
@JsonProperty("allow_rebase_merge") 

boolean allow_rebase_merge;
@JsonProperty("allow_auto_merge") 

boolean allow_auto_merge;
@JsonProperty("delete_branch_on_merge") 

boolean delete_branch_on_merge;
@JsonProperty("allow_update_branch") 

boolean allow_update_branch;
@JsonProperty("use_squash_pr_title_as_default") 
String use_squash_pr_title_as_default;
@JsonProperty("squash_merge_commit_message") 
String squash_merge_commit_message;

@JsonProperty("squash_merge_commit_title") 

String squash_merge_commit_title;
@JsonProperty("merge_commit_message") 

String merge_commit_message;
@JsonProperty("merge_commit_title") 
 
String merge_commit_title;
@JsonProperty("security_and_analysis") 

SecurityAndAnalysis security_and_analysis;
@JsonProperty("network_count") 

	 
int network_count;
@JsonProperty("subscribers_count") 
 
int subscribers_count;
}


