package d.a.o0.e3.n0;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tieba.R;
import d.a.c.a.g;
import d.a.n0.r.s.a;
import d.a.n0.s.c.l;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static AtomicBoolean f57960a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static List<Integer> f57961b = Arrays.asList(Integer.valueOf((int) NetWorkErr.ERROR_UEG_IDENTITY_VERIFY), Integer.valueOf((int) NetWorkErr.ERROR_UEG_PHONE_VERIFY), Integer.valueOf((int) NetWorkErr.ERROR_UEG_MODIFY_PWD), Integer.valueOf((int) NetWorkErr.ERROR_UEG_FACE_VERIFY), Integer.valueOf((int) NetWorkErr.ERROR_UEG_DOUBLE_CHECK), Integer.valueOf((int) NetWorkErr.ERROR_UEG_BIND_MOBILE));

    /* loaded from: classes5.dex */
    public static class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r.s.a f57962e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f57963f;

        public a(d.a.n0.r.s.a aVar, l lVar) {
            this.f57962e = aVar;
            this.f57963f = lVar;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            this.f57962e.dismiss();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921372, this.f57963f));
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r.s.a f57964e;

        public b(d.a.n0.r.s.a aVar) {
            this.f57964e = aVar;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            this.f57964e.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class c {
        public abstract void a(String str);

        public void b(l.c cVar) {
            if (cVar != null && cVar.f54272a) {
                if (cVar instanceof l.a) {
                    a(((l.a) cVar).f54270b);
                    return;
                } else if (cVar instanceof l.b) {
                    c(((l.b) cVar).f54271b);
                    return;
                } else {
                    e();
                    return;
                }
            }
            d();
        }

        public abstract void c(String str);

        public abstract void d();

        public abstract void e();
    }

    public static boolean a(int i2, AuthTokenData authTokenData, c cVar) {
        if (f57961b.contains(Integer.valueOf(i2))) {
            if ((i2 == 3250020 || i2 == 3250021) && (authTokenData == null || TextUtils.isEmpty(authTokenData.getAuthToken()))) {
                return false;
            }
            return c(i2, authTokenData.getAuthToken(), cVar);
        }
        return false;
    }

    public static boolean b(int i2, String str, c cVar) {
        if (f57961b.contains(Integer.valueOf(i2))) {
            if ((i2 == 3250020 || i2 == 3250021) && TextUtils.isEmpty(str)) {
                return false;
            }
            return c(i2, str, cVar);
        }
        return false;
    }

    public static boolean c(int i2, String str, c cVar) {
        l a2;
        if (f57960a.compareAndSet(false, true)) {
            String.valueOf(System.currentTimeMillis());
            if (i2 == 3250022) {
                l d2 = l.d();
                d2.h(cVar);
                if (cVar != null) {
                    cVar.d();
                }
                if (TbadkCoreApplication.getInst().getCurrentActivity() != null) {
                    d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(TbadkCoreApplication.getInst().getCurrentActivity());
                    aVar.setMessageId(R.string.anti_account_modifypwd_tip);
                    aVar.setPositiveButton(R.string.modify_pwd, new a(aVar, d2));
                    aVar.setNegativeButton(R.string.cancel, new b(aVar));
                    if (TbadkCoreApplication.getInst().getCurrentActivity() instanceof g) {
                        aVar.create(((g) TbadkCoreApplication.getInst().getCurrentActivity()).getPageContext());
                        aVar.show();
                    }
                }
            } else {
                if (i2 == 3250017) {
                    a2 = l.b();
                } else if (i2 == 3250023) {
                    a2 = l.c();
                } else if (i2 == 3250024) {
                    a2 = new l(4, null);
                } else {
                    a2 = l.a(str);
                }
                a2.h(cVar);
                MessageManager.getInstance().sendMessage(new CustomMessage(2921372, a2));
            }
            f57960a.set(false);
            return true;
        }
        return false;
    }
}
