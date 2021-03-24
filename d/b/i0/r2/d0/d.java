package d.b.i0.r2.d0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f59825a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final Context f59826b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f59827c;

    public d(Context context, ViewGroup viewGroup) {
        this.f59826b = context;
        this.f59827c = viewGroup;
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

    public e b(AdCard.g gVar, e eVar) {
        String str;
        if (gVar == null || (str = gVar.f20717a) == null) {
            return eVar;
        }
        if (eVar == null || !a(str, eVar.f59828a)) {
            ViewGroup viewGroup = this.f59827c;
            if (viewGroup == null) {
                return null;
            }
            viewGroup.removeAllViews();
            if (TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(gVar.f20717a)) {
                if (this.f59825a == 1) {
                    return new c(LayoutInflater.from(this.f59826b).inflate(R.layout.videolist_tail_frame_ad_jump, this.f59827c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                }
                return new b(LayoutInflater.from(this.f59826b).inflate(R.layout.tail_frame_ad_jump, this.f59827c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
            } else if ("apk_download".equals(gVar.f20717a)) {
                return new a(LayoutInflater.from(this.f59826b).inflate(R.layout.tail_frame_ad_download, this.f59827c, true), "apk_download");
            } else {
                return null;
            }
        }
        return eVar;
    }
}
