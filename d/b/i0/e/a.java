package d.b.i0.e;

import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final String f50849f = String.valueOf(Integer.MAX_VALUE);

    /* renamed from: g  reason: collision with root package name */
    public static final String f50850g = String.valueOf(2147483646);

    /* renamed from: a  reason: collision with root package name */
    public String f50851a;

    /* renamed from: b  reason: collision with root package name */
    public String f50852b;

    /* renamed from: c  reason: collision with root package name */
    public int f50853c;

    /* renamed from: d  reason: collision with root package name */
    public MediaFileInfo f50854d;

    /* renamed from: e  reason: collision with root package name */
    public List<MediaFileInfo> f50855e;

    public void a() {
        this.f50853c++;
    }

    public String b() {
        return this.f50851a;
    }

    public int c() {
        return this.f50853c;
    }

    public List<MediaFileInfo> d() {
        return this.f50855e;
    }

    public ImageFileInfo e() {
        MediaFileInfo mediaFileInfo = this.f50854d;
        if (mediaFileInfo instanceof ImageFileInfo) {
            return (ImageFileInfo) mediaFileInfo;
        }
        return null;
    }

    public MediaFileInfo f() {
        return this.f50854d;
    }

    public String g() {
        return this.f50852b;
    }

    public void h(String str) {
        this.f50851a = str;
    }

    public void i(String str) {
        this.f50853c = d.b.c.e.m.b.d(str, 0);
    }

    public void j(List<MediaFileInfo> list) {
        this.f50855e = list;
    }

    public void k(MediaFileInfo mediaFileInfo) {
        this.f50854d = mediaFileInfo;
    }

    public void l(String str) {
        this.f50852b = str;
    }
}
