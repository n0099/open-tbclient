package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.t;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes6.dex */
public final class k extends v<Time> {

    /* renamed from: a  reason: collision with root package name */
    public static final w f29950a = new w() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.k.1
        @Override // com.bytedance.sdk.openadsdk.preload.a.w
        public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
            if (aVar.a() == Time.class) {
                return new k();
            }
            return null;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final DateFormat f29951b = new SimpleDateFormat("hh:mm:ss a");

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    /* renamed from: a */
    public synchronized Time b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
            aVar.j();
            return null;
        }
        try {
            return new Time(this.f29951b.parse(aVar.h()).getTime());
        } catch (ParseException e2) {
            throw new t(e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public synchronized void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Time time) throws IOException {
        cVar.b(time == null ? null : this.f29951b.format((Date) time));
    }
}
