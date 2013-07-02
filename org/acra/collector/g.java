package org.acra.collector;

import android.os.Process;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import org.acra.util.BoundedLinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g {
    public static String a(String str) {
        String str2;
        int i;
        int myPid = Process.myPid();
        if (!org.acra.a.d().F() || myPid <= 0) {
            str2 = null;
        } else {
            str2 = Integer.toString(myPid) + "):";
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("logcat");
        if (str != null) {
            arrayList.add("-b");
            arrayList.add(str);
        }
        ArrayList arrayList2 = new ArrayList(Arrays.asList(org.acra.a.d().n()));
        int indexOf = arrayList2.indexOf("-t");
        if (indexOf <= -1 || indexOf >= arrayList2.size()) {
            i = -1;
        } else {
            i = Integer.parseInt((String) arrayList2.get(indexOf + 1));
            if (a.a() < 8) {
                arrayList2.remove(indexOf + 1);
                arrayList2.remove(indexOf);
                arrayList2.add("-d");
            }
        }
        if (i <= 0) {
            i = 100;
        }
        BoundedLinkedList boundedLinkedList = new BoundedLinkedList(i);
        arrayList.addAll(arrayList2);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec((String[]) arrayList.toArray(new String[arrayList.size()])).getInputStream()), 8192);
            Log.d(org.acra.a.a, "Retrieving logcat output...");
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (str2 == null || readLine.contains(str2)) {
                    boundedLinkedList.add(readLine + "\n");
                }
            }
        } catch (IOException e) {
            Log.e(org.acra.a.a, "LogCatCollector.collectLogCat could not retrieve data.", e);
        }
        return boundedLinkedList.toString();
    }
}
