package d.a.n0.e;

import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String f53080f = String.valueOf(Integer.MAX_VALUE);

    /* renamed from: g  reason: collision with root package name */
    public static final String f53081g = String.valueOf(2147483646);

    /* renamed from: a  reason: collision with root package name */
    public String f53082a;

    /* renamed from: b  reason: collision with root package name */
    public String f53083b;

    /* renamed from: c  reason: collision with root package name */
    public int f53084c;

    /* renamed from: d  reason: collision with root package name */
    public MediaFileInfo f53085d;

    /* renamed from: e  reason: collision with root package name */
    public List<MediaFileInfo> f53086e;

    public void a() {
        this.f53084c++;
    }

    public String b() {
        return this.f53082a;
    }

    public int c() {
        return this.f53084c;
    }

    public List<MediaFileInfo> d() {
        return this.f53086e;
    }

    public ImageFileInfo e() {
        MediaFileInfo mediaFileInfo = this.f53085d;
        if (mediaFileInfo instanceof ImageFileInfo) {
            return (ImageFileInfo) mediaFileInfo;
        }
        return null;
    }

    public MediaFileInfo f() {
        return this.f53085d;
    }

    public String g() {
        return this.f53083b;
    }

    public void h(String str) {
        this.f53082a = str;
    }

    public void i(String str) {
        this.f53084c = d.a.c.e.m.b.d(str, 0);
    }

    public void j(List<MediaFileInfo> list) {
        this.f53086e = list;
    }

    public void k(MediaFileInfo mediaFileInfo) {
        this.f53085d = mediaFileInfo;
    }

    public void l(String str) {
        this.f53083b = str;
    }
}
