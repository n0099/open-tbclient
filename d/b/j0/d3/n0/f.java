package d.b.j0.d3.n0;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tieba.R;
import d.b.c.a.g;
import d.b.i0.r.s.a;
import d.b.i0.s.c.l;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static AtomicBoolean f55385a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static List<Integer> f55386b = Arrays.asList(Integer.valueOf((int) NetWorkErr.ERROR_UEG_IDENTITY_VERIFY), Integer.valueOf((int) NetWorkErr.ERROR_UEG_PHONE_VERIFY), Integer.valueOf((int) NetWorkErr.ERROR_UEG_MODIFY_PWD), Integer.valueOf((int) NetWorkErr.ERROR_UEG_FACE_VERIFY), Integer.valueOf((int) NetWorkErr.ERROR_UEG_DOUBLE_CHECK), Integer.valueOf((int) NetWorkErr.ERROR_UEG_BIND_MOBILE));

    /* loaded from: classes5.dex */
    public static class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.a f55387e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f55388f;

        public a(d.b.i0.r.s.a aVar, l lVar) {
            this.f55387e = aVar;
            this.f55388f = lVar;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            this.f55387e.dismiss();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921372, this.f55388f));
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.a f55389e;

        public b(d.b.i0.r.s.a aVar) {
            this.f55389e = aVar;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            this.f55389e.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class c {
        public abstract void a(String str);

        public void b(l.c cVar) {
            if (cVar != null && cVar.f51949a) {
                if (cVar instanceof l.a) {
                    a(((l.a) cVar).f51947b);
                    return;
                } else if (cVar instanceof l.b) {
                    c(((l.b) cVar).f51948b);
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

    public static boolean a(int i, AuthTokenData authTokenData, c cVar) {
        if (f55386b.contains(Integer.valueOf(i))) {
            if ((i == 3250020 || i == 3250021) && (authTokenData == null || TextUtils.isEmpty(authTokenData.getAuthToken()))) {
                return false;
            }
            return c(i, authTokenData.getAuthToken(), cVar);
        }
        return false;
    }

    public static boolean b(int i, String str, c cVar) {
        if (f55386b.contains(Integer.valueOf(i))) {
            if ((i == 3250020 || i == 3250021) && TextUtils.isEmpty(str)) {
                return false;
            }
            return c(i, str, cVar);
        }
        return false;
    }

    public static boolean c(int i, String str, c cVar) {
        l a2;
        if (f55385a.compareAndSet(false, true)) {
            String.valueOf(System.currentTimeMillis());
            if (i == 3250022) {
                l d2 = l.d();
                d2.h(cVar);
                if (cVar != null) {
                    cVar.d();
                }
                if (TbadkCoreApplication.getInst().getCurrentActivity() != null) {
                    d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(TbadkCoreApplication.getInst().getCurrentActivity());
                    aVar.setMessageId(R.string.anti_account_modifypwd_tip);
                    aVar.setPositiveButton(R.string.modify_pwd, new a(aVar, d2));
                    aVar.setNegativeButton(R.string.cancel, new b(aVar));
                    if (TbadkCoreApplication.getInst().getCurrentActivity() instanceof g) {
                        aVar.create(((g) TbadkCoreApplication.getInst().getCurrentActivity()).getPageContext());
                        aVar.show();
                    }
                }
            } else {
                if (i == 3250017) {
                    a2 = l.b();
                } else if (i == 3250023) {
                    a2 = l.c();
                } else if (i == 3250024) {
                    a2 = new l(4, null);
                } else {
                    a2 = l.a(str);
                }
                a2.h(cVar);
                MessageManager.getInstance().sendMessage(new CustomMessage(2921372, a2));
            }
            f55385a.set(false);
            return true;
        }
        return false;
    }
}
