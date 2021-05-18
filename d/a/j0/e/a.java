package d.a.j0.e;

import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String f49255f = String.valueOf(Integer.MAX_VALUE);

    /* renamed from: g  reason: collision with root package name */
    public static final String f49256g = String.valueOf(2147483646);

    /* renamed from: a  reason: collision with root package name */
    public String f49257a;

    /* renamed from: b  reason: collision with root package name */
    public String f49258b;

    /* renamed from: c  reason: collision with root package name */
    public int f49259c;

    /* renamed from: d  reason: collision with root package name */
    public MediaFileInfo f49260d;

    /* renamed from: e  reason: collision with root package name */
    public List<MediaFileInfo> f49261e;

    public void a() {
        this.f49259c++;
    }

    public String b() {
        return this.f49257a;
    }

    public int c() {
        return this.f49259c;
    }

    public List<MediaFileInfo> d() {
        return this.f49261e;
    }

    public ImageFileInfo e() {
        MediaFileInfo mediaFileInfo = this.f49260d;
        if (mediaFileInfo instanceof ImageFileInfo) {
            return (ImageFileInfo) mediaFileInfo;
        }
        return null;
    }

    public MediaFileInfo f() {
        return this.f49260d;
    }

    public String g() {
        return this.f49258b;
    }

    public void h(String str) {
        this.f49257a = str;
    }

    public void i(String str) {
        this.f49259c = d.a.c.e.m.b.d(str, 0);
    }

    public void j(List<MediaFileInfo> list) {
        this.f49261e = list;
    }

    public void k(MediaFileInfo mediaFileInfo) {
        this.f49260d = mediaFileInfo;
    }

    public void l(String str) {
        this.f49258b = str;
    }
}
