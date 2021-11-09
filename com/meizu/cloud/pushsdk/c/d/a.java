package com.meizu.cloud.pushsdk.c.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.wallet.fastpay.entrance.DoPhoneChargeAction;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class a implements d {

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f67538b;

    /* renamed from: c  reason: collision with root package name */
    public b f67539c;

    /* renamed from: f  reason: collision with root package name */
    public int f67542f;

    /* renamed from: a  reason: collision with root package name */
    public String f67537a = a.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public String[] f67540d = {"id", DoPhoneChargeAction.EVENT_DATAS_KEY, "dateCreated"};

    /* renamed from: e  reason: collision with root package name */
    public long f67541e = -1;

    public a(Context context, int i2) {
        this.f67539c = b.a(context, a(context));
        b();
        this.f67542f = i2;
    }

    private String a(Context context) {
        String processName = MzSystemUtils.getProcessName(context);
        if (TextUtils.isEmpty(processName)) {
            return "PushEvents.db";
        }
        return processName + "_PushEvents.db";
    }

    public static Map<String, String> a(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            HashMap hashMap = (HashMap) objectInputStream.readObject();
            objectInputStream.close();
            byteArrayInputStream.close();
            return hashMap;
        } catch (IOException | ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] a(Map<String, String> map) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(map);
            objectOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public List<Map<String, Object>> a(int i2) {
        return a(null, "id ASC LIMIT " + i2);
    }

    public List<Map<String, Object>> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (e()) {
            Cursor query = this.f67538b.query("events", this.f67540d, str, null, null, null, str2);
            query.moveToFirst();
            while (!query.isAfterLast()) {
                HashMap hashMap = new HashMap();
                hashMap.put("id", Long.valueOf(query.getLong(0)));
                hashMap.put(DoPhoneChargeAction.EVENT_DATAS_KEY, a(query.getBlob(1)));
                hashMap.put("dateCreated", query.getString(2));
                query.moveToNext();
                arrayList.add(hashMap);
            }
            query.close();
        }
        return arrayList;
    }

    @Override // com.meizu.cloud.pushsdk.c.d.d
    public void a(com.meizu.cloud.pushsdk.c.a.a aVar) {
        b(aVar);
    }

    @Override // com.meizu.cloud.pushsdk.c.d.d
    public boolean a() {
        return e();
    }

    @Override // com.meizu.cloud.pushsdk.c.d.d
    public boolean a(long j) {
        int i2;
        if (e()) {
            SQLiteDatabase sQLiteDatabase = this.f67538b;
            i2 = sQLiteDatabase.delete("events", "id=" + j, null);
        } else {
            i2 = -1;
        }
        String str = this.f67537a;
        com.meizu.cloud.pushsdk.c.f.c.b(str, "Removed event from database: " + j, new Object[0]);
        return i2 == 1;
    }

    public long b(com.meizu.cloud.pushsdk.c.a.a aVar) {
        if (e()) {
            byte[] a2 = a(aVar.a());
            ContentValues contentValues = new ContentValues(2);
            contentValues.put(DoPhoneChargeAction.EVENT_DATAS_KEY, a2);
            this.f67541e = this.f67538b.insert("events", null, contentValues);
        }
        String str = this.f67537a;
        com.meizu.cloud.pushsdk.c.f.c.b(str, "Added event to database: " + this.f67541e, new Object[0]);
        return this.f67541e;
    }

    public void b() {
        if (e()) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = this.f67539c.getWritableDatabase();
            this.f67538b = writableDatabase;
            writableDatabase.enableWriteAheadLogging();
        } catch (Exception e2) {
            String str = this.f67537a;
            com.meizu.cloud.pushsdk.c.f.c.a(str, " open database error " + e2.getMessage(), new Object[0]);
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.d.d
    public long c() {
        if (e()) {
            return DatabaseUtils.queryNumEntries(this.f67538b, "events");
        }
        return 0L;
    }

    @Override // com.meizu.cloud.pushsdk.c.d.d
    public com.meizu.cloud.pushsdk.c.b.b d() {
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        for (Map<String, Object> map : a(this.f67542f)) {
            com.meizu.cloud.pushsdk.c.a.c cVar = new com.meizu.cloud.pushsdk.c.a.c();
            cVar.a((Map) map.get(DoPhoneChargeAction.EVENT_DATAS_KEY));
            linkedList.add((Long) map.get("id"));
            arrayList.add(cVar);
        }
        return new com.meizu.cloud.pushsdk.c.b.b(arrayList, linkedList);
    }

    public boolean e() {
        SQLiteDatabase sQLiteDatabase = this.f67538b;
        return sQLiteDatabase != null && sQLiteDatabase.isOpen();
    }
}
