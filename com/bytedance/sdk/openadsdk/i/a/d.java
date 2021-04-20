package com.bytedance.sdk.openadsdk.i.a;

import android.graphics.Bitmap;
import com.bytedance.sdk.openadsdk.utils.f;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f29178a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f29179b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.c.c.b.d.a> f29180c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f29181d;

    public d(byte[] bArr) {
        this.f29178a = null;
        this.f29179b = null;
        this.f29180c = null;
        this.f29181d = null;
        this.f29178a = bArr;
    }

    public Bitmap a() {
        return this.f29179b;
    }

    public byte[] b() {
        if (this.f29178a == null) {
            this.f29178a = f.b(this.f29179b);
        }
        return this.f29178a;
    }

    public boolean c() {
        if (this.f29179b != null) {
            return true;
        }
        byte[] bArr = this.f29178a;
        return bArr != null && bArr.length > 0;
    }

    public boolean d() {
        byte[] bArr = this.f29178a;
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    public Map<String, String> e() {
        return this.f29181d;
    }

    public void a(List<d.c.c.b.d.a> list) {
        this.f29180c = list;
    }

    public void a(Map<String, String> map) {
        this.f29181d = map;
    }

    public d(Bitmap bitmap) {
        this.f29178a = null;
        this.f29179b = null;
        this.f29180c = null;
        this.f29181d = null;
        this.f29179b = bitmap;
    }
}
