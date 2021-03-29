package d.b.i0.u3.l;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public final d.b.b.a.f f61592b;

    /* renamed from: c  reason: collision with root package name */
    public WriteImagesInfo f61593c;

    /* renamed from: d  reason: collision with root package name */
    public VideoFileInfo f61594d;

    /* renamed from: e  reason: collision with root package name */
    public String f61595e;

    /* renamed from: f  reason: collision with root package name */
    public ImageFileInfo f61596f;

    /* renamed from: g  reason: collision with root package name */
    public List<ImageFileInfo> f61597g;

    /* renamed from: a  reason: collision with root package name */
    public int f61591a = 9;

    /* renamed from: h  reason: collision with root package name */
    public final List<d.b.h0.e.a> f61598h = new ArrayList();

    public c(d.b.b.a.f fVar) {
        this.f61592b = fVar;
    }

    public void A(String str) {
        if (this.f61593c == null) {
            this.f61593c = new WriteImagesInfo(this.f61591a);
        }
        this.f61593c.setLastAlbumId(str);
    }

    public void B(boolean z) {
        WriteImagesInfo writeImagesInfo = this.f61593c;
        if (writeImagesInfo != null) {
            writeImagesInfo.setOriginalImg(z);
        }
    }

    public void C(WriteImagesInfo writeImagesInfo) {
        this.f61593c = writeImagesInfo;
    }

    public int D() {
        WriteImagesInfo writeImagesInfo = this.f61593c;
        if (writeImagesInfo == null) {
            return 0;
        }
        return writeImagesInfo.size();
    }

    public void a(ImageFileInfo imageFileInfo) {
        if (this.f61593c == null) {
            this.f61593c = new WriteImagesInfo(this.f61591a);
        }
        this.f61593c.addChooseFile(imageFileInfo);
    }

    public void b() {
        WriteImagesInfo writeImagesInfo = this.f61593c;
        if (writeImagesInfo == null) {
            return;
        }
        writeImagesInfo.clear();
    }

    public void c(ImageFileInfo imageFileInfo) {
        WriteImagesInfo writeImagesInfo = this.f61593c;
        if (writeImagesInfo == null) {
            return;
        }
        writeImagesInfo.delChooseFile(imageFileInfo);
    }

    public List<MediaFileInfo> d(String str) {
        if (this.f61598h != null && !StringUtils.isNull(str)) {
            for (d.b.h0.e.a aVar : this.f61598h) {
                if (aVar != null && TextUtils.equals(str, aVar.b())) {
                    return aVar.d();
                }
            }
        }
        return null;
    }

    public List<d.b.h0.e.a> e() {
        return this.f61598h;
    }

    public VideoFileInfo f() {
        return this.f61594d;
    }

    public List<ImageFileInfo> g() {
        WriteImagesInfo writeImagesInfo = this.f61593c;
        if (writeImagesInfo != null) {
            return writeImagesInfo.getChosedFiles();
        }
        return null;
    }

    public String h() {
        return this.f61595e;
    }

    public List<ImageFileInfo> i() {
        return this.f61597g;
    }

    public int j() {
        List<ImageFileInfo> list;
        ImageFileInfo imageFileInfo = this.f61596f;
        if (imageFileInfo != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && (list = this.f61597g) != null && list.size() != 0) {
            int size = this.f61597g.size();
            for (int i = 0; i < size; i++) {
                ImageFileInfo imageFileInfo2 = this.f61597g.get(i);
                if (imageFileInfo2 != null && this.f61596f.getFilePath().equals(imageFileInfo2.getFilePath())) {
                    return i;
                }
            }
        }
        return 0;
    }

    public String k() {
        WriteImagesInfo writeImagesInfo = this.f61593c;
        if (writeImagesInfo != null) {
            return writeImagesInfo.getLastAlbumId();
        }
        return null;
    }

    public int l() {
        WriteImagesInfo writeImagesInfo = this.f61593c;
        if (writeImagesInfo != null) {
            return writeImagesInfo.getMaxImagesAllowed();
        }
        return 0;
    }

    public WriteImagesInfo m() {
        return this.f61593c;
    }

    public boolean n(ImageFileInfo imageFileInfo) {
        WriteImagesInfo writeImagesInfo = this.f61593c;
        if (writeImagesInfo == null) {
            return false;
        }
        return writeImagesInfo.isAdded(imageFileInfo);
    }

    public boolean o() {
        return !ListUtils.isEmpty(g());
    }

    public boolean p() {
        return this.f61594d != null;
    }

    public boolean q(VideoFileInfo videoFileInfo) {
        VideoFileInfo videoFileInfo2 = this.f61594d;
        return (videoFileInfo2 == null || videoFileInfo == null || videoFileInfo2.videoId != videoFileInfo.videoId) ? false : true;
    }

    public boolean r() {
        return ListUtils.isEmpty(d(d.b.h0.e.a.f50120f));
    }

    public boolean s() {
        WriteImagesInfo writeImagesInfo = this.f61593c;
        if (writeImagesInfo != null) {
            return writeImagesInfo.isOriginalImg();
        }
        return false;
    }

    public d.b.h0.e.a t(List<MediaFileInfo> list) {
        d.b.h0.e.a aVar = new d.b.h0.e.a();
        aVar.h(d.b.h0.e.a.f50120f);
        aVar.l(this.f61592b.getString(R.string.album_all_media));
        int count = ListUtils.getCount(list);
        aVar.j(list);
        aVar.i(String.valueOf(count));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) ListUtils.getItem(list, count - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            aVar.k((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            aVar.k((VideoFileInfo) mediaFileInfo);
        }
        return aVar;
    }

    public d.b.h0.e.a u(List<VideoFileInfo> list) {
        d.b.h0.e.a aVar = new d.b.h0.e.a();
        aVar.h(d.b.h0.e.a.f50121g);
        aVar.l(this.f61592b.getString(R.string.album_all_video));
        int count = ListUtils.getCount(list);
        aVar.i(String.valueOf(count));
        ArrayList arrayList = new ArrayList();
        if (!ListUtils.isEmpty(list)) {
            arrayList.addAll(list);
        }
        aVar.j(arrayList);
        VideoFileInfo videoFileInfo = (VideoFileInfo) ListUtils.getItem(list, count - 1);
        if (videoFileInfo != null) {
            aVar.k(videoFileInfo);
        }
        return aVar;
    }

    public final void v(String str) {
        if (this.f61598h == null || StringUtils.isNull(str)) {
            return;
        }
        for (d.b.h0.e.a aVar : this.f61598h) {
            if (aVar != null && TextUtils.equals(str, aVar.b())) {
                ArrayList arrayList = new ArrayList();
                if (aVar.d() != null) {
                    for (MediaFileInfo mediaFileInfo : aVar.d()) {
                        if (mediaFileInfo instanceof ImageFileInfo) {
                            arrayList.add((ImageFileInfo) mediaFileInfo);
                        }
                    }
                }
                this.f61597g = arrayList;
            }
        }
    }

    public void w(VideoFileInfo videoFileInfo) {
        this.f61594d = videoFileInfo;
    }

    public void x(String str) {
        this.f61595e = str;
        v(str);
    }

    public void y(ImageFileInfo imageFileInfo) {
        this.f61596f = imageFileInfo;
    }

    public void z(d.b.h0.e.g gVar) {
        if (gVar == null) {
            return;
        }
        List<MediaFileInfo> list = gVar.f50152b;
        ArrayList arrayList = new ArrayList();
        arrayList.add(t(list));
        if (!ListUtils.isEmpty(gVar.f50153c)) {
            arrayList.add(u(gVar.f50153c));
        }
        if (!ListUtils.isEmpty(gVar.f50151a)) {
            arrayList.addAll(gVar.f50151a);
        }
        this.f61598h.clear();
        this.f61598h.addAll(arrayList);
    }
}
