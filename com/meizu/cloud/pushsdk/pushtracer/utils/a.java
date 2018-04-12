package com.meizu.cloud.pushsdk.pushtracer.utils;

import android.content.Context;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private static final String a = a.class.getSimpleName();

    public static boolean a(String str, Map map, Context context) {
        try {
            b.b(a, "Attempting to save: %s", map);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(context.openFileOutput(str, 0));
            objectOutputStream.writeObject(map);
            objectOutputStream.close();
            b.b(a, " + Successfully saved KV Pairs to: %s", str);
            return true;
        } catch (IOException e) {
            b.a(a, " + Exception saving vars map: %s", e.getMessage());
            return false;
        }
    }

    public static Map a(String str, Context context) {
        try {
            b.b(a, "Attempting to retrieve map from: %s", str);
            ObjectInputStream objectInputStream = new ObjectInputStream(context.openFileInput(str));
            HashMap hashMap = (HashMap) objectInputStream.readObject();
            objectInputStream.close();
            b.b(a, " + Retrieved map from file: %s", hashMap);
            return hashMap;
        } catch (IOException | ClassNotFoundException e) {
            b.a(a, " + Exception getting vars map: %s", e.getMessage());
            return null;
        }
    }
}
