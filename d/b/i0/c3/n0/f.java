package d.b.i0.c3.n0;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tieba.R;
import d.b.b.a.g;
import d.b.h0.r.s.a;
import d.b.h0.s.c.j;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static AtomicBoolean f53520a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static List<Integer> f53521b = Arrays.asList(Integer.valueOf((int) NetWorkErr.ERROR_UEG_IDENTITY_VERIFY), Integer.valueOf((int) NetWorkErr.ERROR_UEG_PHONE_VERIFY), Integer.valueOf((int) NetWorkErr.ERROR_UEG_MODIFY_PWD), Integer.valueOf((int) NetWorkErr.ERROR_UEG_FACE_VERIFY), Integer.valueOf((int) NetWorkErr.ERROR_UEG_DOUBLE_CHECK), Integer.valueOf((int) NetWorkErr.ERROR_UEG_BIND_MOBILE));

    /* loaded from: classes5.dex */
    public static class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f53522e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f53523f;

        public a(d.b.h0.r.s.a aVar, j jVar) {
            this.f53522e = aVar;
            this.f53523f = jVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f53522e.dismiss();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921372, this.f53523f));
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f53524e;

        public b(d.b.h0.r.s.a aVar) {
            this.f53524e = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f53524e.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class c {
        public abstract void a(String str);

        public void b(j.c cVar) {
            if (cVar != null && cVar.f51187a) {
                if (cVar instanceof j.a) {
                    a(((j.a) cVar).f51185b);
                    return;
                } else if (cVar instanceof j.b) {
                    c(((j.b) cVar).f51186b);
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
        if (f53521b.contains(Integer.valueOf(i))) {
            if ((i == 3250020 || i == 3250021) && (authTokenData == null || TextUtils.isEmpty(authTokenData.getAuthToken()))) {
                return false;
            }
            return c(i, authTokenData.getAuthToken(), cVar);
        }
        return false;
    }

    public static boolean b(int i, String str, c cVar) {
        if (f53521b.contains(Integer.valueOf(i))) {
            if ((i == 3250020 || i == 3250021) && TextUtils.isEmpty(str)) {
                return false;
            }
            return c(i, str, cVar);
        }
        return false;
    }

    public static boolean c(int i, String str, c cVar) {
        j a2;
        if (f53520a.compareAndSet(false, true)) {
            String.valueOf(System.currentTimeMillis());
            if (i == 3250022) {
                j d2 = j.d();
                d2.h(cVar);
                if (cVar != null) {
                    cVar.d();
                }
                if (TbadkCoreApplication.getInst().getCurrentActivity() != null) {
                    d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(TbadkCoreApplication.getInst().getCurrentActivity());
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
                    a2 = j.b();
                } else if (i == 3250023) {
                    a2 = j.c();
                } else if (i == 3250024) {
                    a2 = new j(4, null);
                } else {
                    a2 = j.a(str);
                }
                a2.h(cVar);
                MessageManager.getInstance().sendMessage(new CustomMessage(2921372, a2));
            }
            f53520a.set(false);
            return true;
        }
        return false;
    }
}
