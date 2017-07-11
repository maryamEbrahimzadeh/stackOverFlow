import java.io.*;

import org.bson.Document;
import org.bson.conversions.Bson;

public class Message implements Serializable {

    static final int SEARCH = 0, LOGIN = 1, LOGOUT = 2, REGISTER = 3,SUGNUP = 4,ASK=5,SHOWALL=6,SEARCH2=7,SHOWFAV=8
    		,QUESTIONTOANSWER=9,ANSWER=10,DELETE=11,SHOWTAG=12,SHOWTHISTAG=13,RATE=14,RATE1=15;
    private int type;
    //public String messages;
    private Document info,user,qu;
    private boolean islogin;
    private String q;
    int qid;
	private Document answer;
	private int aid;
	private boolean isquistioner;

    // constructor

    Message(int type, Document info) {
        this.type = type;
        this.info = info;
    }
    Message(int type) {
        this.type = type;
    }
    Message(int type, boolean islogin, Document user) {
        this.type = type;
        this.islogin = islogin;
        this.user = user;
    }
    Message(int type, String q) {
        this.type = type;
        this.q = q;
    }
    Message(int type,Document  qu, boolean isquistioner) {
        this.type = type;
        this.isquistioner = isquistioner;
        this.qu = qu;
    }
    Message(int type, String q,Document user) {
        this.type = type;
        this.q = q;
        this.user = user;
    }
    Message(int type, Document  qu,Document user) {
        this.type = type;
        this.qu = qu;
        this.user = user;
    }
    Message(int type, int qid,Document answer ) {
        this.type = type;
        this.answer = answer;
        this.qid = qid;
    }
    Message(int type, Document qu,int aid ) {//for rate
        this.type = type;
        this.qu = qu;
        this.aid = aid;        
    }
    // getters
    int getType() {
        return type;
    }
    int getQid() {
        return qid;
    }
    int getAid() {
        return aid;
    }
    Document getInfo() {
        return info;
    }
    Document getanswer() {
        return answer;
    }
    Document getUser() {
        return user;
    }
    Document getqu() {
        return qu;
    }
    boolean getIslogin() {
        return islogin;
    }
    boolean getIsQuistioner() {
        return isquistioner;
    }
    String getquestion(){
    	return q;
    }
}

