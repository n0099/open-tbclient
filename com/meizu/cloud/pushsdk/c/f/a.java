package com.meizu.cloud.pushsdk.c.f;

import android.content.Context;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f68499a = "a";

    public static Map a(String str, Context context) {
        try {
            c.b(f68499a, "Attempting to retrieve map from: %s", str);
            ObjectInputStream objectInputStream = new ObjectInputStream(context.openFileInput(str));
            HashMap hashMap = (HashMap) objectInputStream.readObject();
            objectInputStream.close();
            c.b(f68499a, " + Retrieved map from file: %s", hashMap);
            return hashMap;
        } catch (IOException | ClassNotFoundException e2) {
            c.a(f68499a, " + Exception getting vars map: %s", e2.getMessage());
            return null;
        }
    }

    public static boolean a(String str, Map map, Context context) {
        try {
            c.b(f68499a, "Attempting to save: %s", map);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(context.openFileOutput(str, 0));
            objectOutputStream.writeObject(map);
            objectOutputStream.close();
            c.b(f68499a, " + Successfully saved KV Pairs to: %s", str);
            return true;
        } catch (IOException e2) {
            c.a(f68499a, " + Exception saving vars map: %s", e2.getMessage());
            return false;
        }
    }
}
