package d.b.j0.s2.h0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f62148a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final Context f62149b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f62150c;

    public d(Context context, ViewGroup viewGroup) {
        this.f62149b = context;
        this.f62150c = viewGroup;
    }

    public final boolean a(String str, String str2) {
        if ("apk_download".equals(str)) {
            return "apk_download".equals(str2);
        }
        if (TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(str)) {
            return TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(str2);
        }
        return false;
    }

    public e b(d.b.j0.s2.c0.b.e eVar, e eVar2) {
        String str;
        if (eVar == null || (str = eVar.f62017a) == null) {
            return eVar2;
        }
        if (eVar2 == null || !a(str, eVar2.f62151a)) {
            ViewGroup viewGroup = this.f62150c;
            if (viewGroup == null) {
                return null;
            }
            viewGroup.removeAllViews();
            if (TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(eVar.f62017a)) {
                if (this.f62148a == 1) {
                    return new c(LayoutInflater.from(this.f62149b).inflate(R.layout.videolist_tail_frame_ad_jump, this.f62150c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                }
                return new b(LayoutInflater.from(this.f62149b).inflate(R.layout.tail_frame_ad_jump, this.f62150c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
            } else if ("apk_download".equals(eVar.f62017a)) {
                return new a(LayoutInflater.from(this.f62149b).inflate(R.layout.tail_frame_ad_download, this.f62150c, true), "apk_download");
            } else {
                return null;
            }
        }
        return eVar2;
    }
}
