package d.a.n0.t2.j0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tieba.R;
import d.a.n0.t2.f0.b.f;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f61186a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final Context f61187b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f61188c;

    public d(Context context, ViewGroup viewGroup) {
        this.f61187b = context;
        this.f61188c = viewGroup;
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

    public e b(f fVar, e eVar) {
        String str;
        if (fVar == null || (str = fVar.f61077a) == null) {
            return eVar;
        }
        if (eVar == null || !a(str, eVar.f61189a)) {
            ViewGroup viewGroup = this.f61188c;
            if (viewGroup == null) {
                return null;
            }
            viewGroup.removeAllViews();
            if (TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(fVar.f61077a)) {
                if (this.f61186a == 1) {
                    return new c(LayoutInflater.from(this.f61187b).inflate(R.layout.videolist_tail_frame_ad_jump, this.f61188c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                }
                return new b(LayoutInflater.from(this.f61187b).inflate(R.layout.tail_frame_ad_jump, this.f61188c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
            } else if ("apk_download".equals(fVar.f61077a)) {
                return new a(LayoutInflater.from(this.f61187b).inflate(R.layout.tail_frame_ad_download, this.f61188c, true), "apk_download");
            } else {
                return null;
            }
        }
        return eVar;
    }
}
