package com.xiaomi.push;

import android.content.Context;
import android.database.Cursor;
import com.xiaomi.push.ci;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class cd extends ci.b<Long> {
    public long a;

    /* renamed from: a  reason: collision with other field name */
    public String f164a;

    public cd(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i, String str6) {
        super(str, list, str2, strArr, str3, str4, str5, i);
        this.a = 0L;
        this.f164a = str6;
    }

    public static cd a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("count(*)");
        return new cd(str, arrayList, null, null, null, null, null, 0, "job to get count of all message");
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaomi.push.ci.b
    public Long a(Context context, Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    @Override // com.xiaomi.push.ci.a
    /* renamed from: a */
    public Object mo332a() {
        return Long.valueOf(this.a);
    }

    @Override // com.xiaomi.push.ci.b
    public void a(Context context, List<Long> list) {
        if (context == null || list == null || list.size() <= 0) {
            return;
        }
        this.a = list.get(0).longValue();
    }
}
