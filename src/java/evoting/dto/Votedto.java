/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.dto;

/**
 *
 * @author Shrasti
 */
public class Votedto {
     public String getCandidateId() {
        return candidateId;
    }
    public void setCandidateId(String candidateId) {
this.candidateId = candidateId;
    }
    public String getVoterId() {
        return voterId;
    }
    public void setVoterId(String voterId) {
this.voterId = voterId;
    }
    private String candidateId;
    private String voterId;

    
}
