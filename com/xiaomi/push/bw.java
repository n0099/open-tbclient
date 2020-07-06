package com.xiaomi.push;

import android.content.Context;
import android.database.Cursor;
import com.xiaomi.push.cb;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class bw extends cb.b<Long> {
    private long a;

    /* renamed from: a  reason: collision with other field name */
    private String f150a;

    public bw(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i, String str6) {
        super(str, list, str2, strArr, str3, str4, str5, i);
        this.a = 0L;
        this.f150a = str6;
    }

    public static bw a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("count(*)");
        return new bw(str, arrayList, null, null, null, null, null, 0, "job to get count of all message");
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaomi.push.cb.b
    public Long a(Context context, Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    @Override // com.xiaomi.push.cb.b, com.xiaomi.push.cb.a
    public Object a() {
        return Long.valueOf(this.a);
    }

    @Override // com.xiaomi.push.cb.b
    public void a(Context context, List<Long> list) {
        if (context == null || list == null || list.size() <= 0) {
            return;
        }
        this.a = list.get(0).longValue();
    }
}
