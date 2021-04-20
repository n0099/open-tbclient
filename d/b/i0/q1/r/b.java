package d.b.i0.q1.r;

import android.content.Context;
import com.baidu.searchbox.live.interfaces.service.ToastService;
import com.baidu.searchbox.live.interfaces.toast.ToastClickListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class b implements ToastService {
    @Override // com.baidu.searchbox.live.interfaces.service.ToastService
    public void showClickableToast(Context context, String str, String str2, int i, ToastClickListener toastClickListener) {
        l.L(TbadkCoreApplication.getInst(), str);
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ToastService
    public void showNormal(Context context, String str, int i) {
        l.L(TbadkCoreApplication.getInst(), str);
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ToastService
    public void showToastBottom(Context context, String str, int i) {
        l.L(TbadkCoreApplication.getInst(), str);
    }
}
