package com.meizu.cloud.pushsdk.c.f;

import android.content.Context;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4407a = a.class.getSimpleName();

    public static Map a(String str, Context context) {
        try {
            c.b(f4407a, "Attempting to retrieve map from: %s", str);
            ObjectInputStream objectInputStream = new ObjectInputStream(context.openFileInput(str));
            HashMap hashMap = (HashMap) objectInputStream.readObject();
            objectInputStream.close();
            c.b(f4407a, " + Retrieved map from file: %s", hashMap);
            return hashMap;
        } catch (IOException | ClassNotFoundException e) {
            c.a(f4407a, " + Exception getting vars map: %s", e.getMessage());
            return null;
        }
    }

    public static boolean a(String str, Map map, Context context) {
        try {
            c.b(f4407a, "Attempting to save: %s", map);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(context.openFileOutput(str, 0));
            objectOutputStream.writeObject(map);
            objectOutputStream.close();
            c.b(f4407a, " + Successfully saved KV Pairs to: %s", str);
            return true;
        } catch (IOException e) {
            c.a(f4407a, " + Exception saving vars map: %s", e.getMessage());
            return false;
        }
    }
}
