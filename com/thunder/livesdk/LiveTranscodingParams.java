package com.thunder.livesdk;

import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import com.thunder.livesdk.LiveTranscoding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class LiveTranscodingParams {
    public String transcodingCofig = null;
    public HashSet<String> transcodingStreamUrls = null;
    public ArrayList<LiveTranscoding.TranscodingUser> usersLayout = new ArrayList<>();
    public HashMap<String, String> extendInfo = new HashMap<>();

    public String userToString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("user List: ");
        Iterator<LiveTranscoding.TranscodingUser> it = this.usersLayout.iterator();
        while (it.hasNext()) {
            LiveTranscoding.TranscodingUser next = it.next();
            stringBuffer.append("channel :" + next.roomId);
            stringBuffer.append("uid: " + next.uid);
            stringBuffer.append("layoutx :" + String.valueOf(next.layoutX));
            stringBuffer.append("layoutY :" + String.valueOf(next.layoutY));
            stringBuffer.append("layoutw :" + String.valueOf(next.layoutW));
            stringBuffer.append("layouth :" + String.valueOf(next.layoutH));
            stringBuffer.append(" ### ");
        }
        return stringBuffer.toString();
    }

    public String extendInfoToString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("extendInfo: ");
        for (String str : this.extendInfo.keySet()) {
            stringBuffer.append("[" + str + PerfFrameTrackUIUtil.SEPERATOR_ARROR + this.extendInfo.get(str) + "], ");
        }
        return stringBuffer.toString();
    }
}
