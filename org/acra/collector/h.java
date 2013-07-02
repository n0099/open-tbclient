package org.acra.collector;

import android.content.Context;
import com.baidu.zeus.NotificationProxy;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import org.acra.util.BoundedLinkedList;
/* loaded from: classes.dex */
class h {
    public static String a(Context context, String str, int i) {
        BufferedReader bufferedReader;
        BoundedLinkedList boundedLinkedList = new BoundedLinkedList(i);
        if (str.contains("/")) {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)), NotificationProxy.MAX_URL_LENGTH);
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(context.openFileInput(str)), NotificationProxy.MAX_URL_LENGTH);
        }
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            boundedLinkedList.add(readLine + "\n");
        }
        return boundedLinkedList.toString();
    }
}
