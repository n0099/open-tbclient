package d.a.j0.n3;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.userblock.UserBlockInfoModel;
import com.baidu.tieba.userblock.UserBlockSetModel;
import d.a.c.e.p.j;
import d.a.i0.r.s.n;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.GetUserBlackInfo.DataRes;
import tbclient.PermissionList;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57024a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f57025b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.i0.r.f0.a f57026c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.i0.r.s.f f57027d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f57028e;

    /* renamed from: f  reason: collision with root package name */
    public long f57029f;

    /* renamed from: g  reason: collision with root package name */
    public UserBlockSetModel f57030g;

    /* renamed from: h  reason: collision with root package name */
    public UserBlockInfoModel f57031h;

    /* renamed from: i  reason: collision with root package name */
    public AdapterView.OnItemClickListener f57032i = new c();
    public View.OnClickListener j = new d();
    public View.OnClickListener k = new e();

    /* loaded from: classes5.dex */
    public class a implements d.a.i0.m.a<String> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.m.a
        /* renamed from: b */
        public void onSuccess(String str) {
            b.this.k();
            d.a.j0.n3.a.f((ViewGroup) b.this.f57024a.getPageActivity().findViewById(16908290), str, true);
        }

        @Override // d.a.i0.m.a
        public void onError(int i2, String str) {
            b.this.k();
            d.a.j0.n3.a.f((ViewGroup) b.this.f57024a.getPageActivity().findViewById(16908290), str, false);
        }
    }

    /* renamed from: d.a.j0.n3.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1369b implements d.a.i0.m.a {
        public C1369b() {
        }

        @Override // d.a.i0.m.a
        public void onError(int i2, String str) {
            if (b.this.f57024a != null) {
                b.this.f57024a.showToast(str);
            }
        }

        @Override // d.a.i0.m.a
        public void onSuccess(Object obj) {
            int i2;
            PermissionList permissionList;
            if (obj instanceof DataRes) {
                DataRes dataRes = (DataRes) obj;
                i2 = dataRes.is_black_white.intValue();
                permissionList = dataRes.perm_list;
            } else {
                i2 = 0;
                permissionList = null;
            }
            if (permissionList != null) {
                b.this.m(i2, permissionList);
            } else if (b.this.f57024a != null) {
                b.this.f57024a.showToast(R.string.error_unkown_try_again);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (((n) ListUtils.getItem(b.this.f57028e, i2)) != null) {
                b.this.f57027d.r(true);
            }
            b.this.f57027d.h(i2);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f57027d.d();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f57027d.d();
            if (b.this.f57028e == null || !j.z() || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return;
            }
            Iterator it = b.this.f57028e.iterator();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (it.hasNext()) {
                n nVar = (n) it.next();
                if (nVar.d() && "1".equals(nVar.b())) {
                    i2 = 1;
                } else if (nVar.d() && "2".equals(nVar.b())) {
                    i3 = 1;
                } else if (nVar.d() && "3".equals(nVar.b())) {
                    i4 = 1;
                }
            }
            b.this.o();
            b.this.f57030g.y(b.this.f57029f, i2, i3, i4);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements DialogInterface.OnCancelListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, b.this.f57025b);
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f57024a = tbPageContext;
        this.f57025b = bdUniqueId;
        UserBlockSetModel userBlockSetModel = new UserBlockSetModel(tbPageContext, bdUniqueId);
        this.f57030g = userBlockSetModel;
        userBlockSetModel.z(new a());
        UserBlockInfoModel userBlockInfoModel = new UserBlockInfoModel(tbPageContext, bdUniqueId);
        this.f57031h = userBlockInfoModel;
        userBlockInfoModel.z(new C1369b());
    }

    public final String j(int i2) {
        return TbadkCoreApplication.getInst().getString(i2);
    }

    public final void k() {
        d.a.i0.r.f0.a aVar = this.f57026c;
        if (aVar != null) {
            aVar.h(false);
        }
    }

    public void l() {
        this.f57029f = -1L;
        d.a.i0.r.f0.a aVar = this.f57026c;
        if (aVar != null) {
            aVar.h(false);
        }
        d.a.i0.r.s.f fVar = this.f57027d;
        if (fVar != null) {
            fVar.d();
        }
        UserBlockInfoModel userBlockInfoModel = this.f57031h;
        if (userBlockInfoModel != null) {
            userBlockInfoModel.onDestroy();
        }
        UserBlockSetModel userBlockSetModel = this.f57030g;
        if (userBlockSetModel != null) {
            userBlockSetModel.onDestroy();
        }
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_GET_USER_BLOCK_INFO, this.f57025b);
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, this.f57025b);
    }

    public final void m(int i2, PermissionList permissionList) {
        boolean z = false;
        boolean z2 = permissionList != null && permissionList.follow.intValue() == 1;
        boolean z3 = permissionList != null && permissionList.interact.intValue() == 1;
        if (permissionList != null && permissionList.chat.intValue() == 1) {
            z = true;
        }
        ArrayList<n> arrayList = new ArrayList<>();
        this.f57028e = arrayList;
        if (i2 == 1) {
            arrayList.add(new n(j(R.string.block_follow), z2, "1"));
            this.f57028e.add(new n(j(R.string.block_action), z3, "2"));
            this.f57028e.add(new n(j(R.string.block_message), z, "3"));
        } else {
            arrayList.add(new n(j(R.string.block_commit), z3, "2"));
            this.f57028e.add(new n(j(R.string.block_message), z, "3"));
        }
        d.a.i0.r.s.f fVar = new d.a.i0.r.s.f(this.f57024a);
        this.f57027d = fVar;
        fVar.l(R.string.block_user_title);
        this.f57027d.k(this.f57028e, this.f57032i);
        this.f57027d.q(R.string.done, this.k);
        this.f57027d.p(R.string.cancel, this.j);
        d.a.i0.r.s.f fVar2 = this.f57027d;
        fVar2.c();
        fVar2.n();
    }

    public void n(long j) {
        this.f57029f = j;
        this.f57031h.y(j);
    }

    public final void o() {
        if (this.f57026c == null) {
            d.a.i0.r.f0.a aVar = new d.a.i0.r.f0.a(this.f57024a);
            this.f57026c = aVar;
            aVar.e(new f());
        }
        this.f57026c.h(true);
    }
}
