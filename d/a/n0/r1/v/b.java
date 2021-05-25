package d.a.n0.r1.v;

import android.content.Context;
import com.baidu.searchbox.live.interfaces.service.ToastService;
import com.baidu.searchbox.live.interfaces.toast.ToastClickListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class b implements ToastService {
    @Override // com.baidu.searchbox.live.interfaces.service.ToastService
    public void showClickableToast(Context context, String str, String str2, int i2, ToastClickListener toastClickListener) {
        l.M(TbadkCoreApplication.getInst(), str);
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ToastService
    public void showNormal(Context context, String str, int i2) {
        l.M(TbadkCoreApplication.getInst(), str);
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ToastService
    public void showToastBottom(Context context, String str, int i2) {
        l.M(TbadkCoreApplication.getInst(), str);
    }
}
