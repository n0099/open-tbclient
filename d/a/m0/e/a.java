package d.a.m0.e;

import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String f49299f = String.valueOf(Integer.MAX_VALUE);

    /* renamed from: g  reason: collision with root package name */
    public static final String f49300g = String.valueOf(2147483646);

    /* renamed from: a  reason: collision with root package name */
    public String f49301a;

    /* renamed from: b  reason: collision with root package name */
    public String f49302b;

    /* renamed from: c  reason: collision with root package name */
    public int f49303c;

    /* renamed from: d  reason: collision with root package name */
    public MediaFileInfo f49304d;

    /* renamed from: e  reason: collision with root package name */
    public List<MediaFileInfo> f49305e;

    public void a() {
        this.f49303c++;
    }

    public String b() {
        return this.f49301a;
    }

    public int c() {
        return this.f49303c;
    }

    public List<MediaFileInfo> d() {
        return this.f49305e;
    }

    public ImageFileInfo e() {
        MediaFileInfo mediaFileInfo = this.f49304d;
        if (mediaFileInfo instanceof ImageFileInfo) {
            return (ImageFileInfo) mediaFileInfo;
        }
        return null;
    }

    public MediaFileInfo f() {
        return this.f49304d;
    }

    public String g() {
        return this.f49302b;
    }

    public void h(String str) {
        this.f49301a = str;
    }

    public void i(String str) {
        this.f49303c = d.a.c.e.m.b.d(str, 0);
    }

    public void j(List<MediaFileInfo> list) {
        this.f49305e = list;
    }

    public void k(MediaFileInfo mediaFileInfo) {
        this.f49304d = mediaFileInfo;
    }

    public void l(String str) {
        this.f49302b = str;
    }
}
