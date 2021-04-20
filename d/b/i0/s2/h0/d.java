package d.b.i0.s2.h0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f61727a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final Context f61728b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f61729c;

    public d(Context context, ViewGroup viewGroup) {
        this.f61728b = context;
        this.f61729c = viewGroup;
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

    public e b(d.b.i0.s2.c0.b.e eVar, e eVar2) {
        String str;
        if (eVar == null || (str = eVar.f61596a) == null) {
            return eVar2;
        }
        if (eVar2 == null || !a(str, eVar2.f61730a)) {
            ViewGroup viewGroup = this.f61729c;
            if (viewGroup == null) {
                return null;
            }
            viewGroup.removeAllViews();
            if (TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(eVar.f61596a)) {
                if (this.f61727a == 1) {
                    return new c(LayoutInflater.from(this.f61728b).inflate(R.layout.videolist_tail_frame_ad_jump, this.f61729c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                }
                return new b(LayoutInflater.from(this.f61728b).inflate(R.layout.tail_frame_ad_jump, this.f61729c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
            } else if ("apk_download".equals(eVar.f61596a)) {
                return new a(LayoutInflater.from(this.f61728b).inflate(R.layout.tail_frame_ad_download, this.f61729c, true), "apk_download");
            } else {
                return null;
            }
        }
        return eVar2;
    }
}
