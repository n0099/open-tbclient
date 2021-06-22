package d.a.o0.o3;

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
import d.a.n0.r.s.n;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.GetUserBlackInfo.DataRes;
import tbclient.PermissionList;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61719a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f61720b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.r.f0.a f61721c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.r.s.f f61722d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f61723e;

    /* renamed from: f  reason: collision with root package name */
    public long f61724f;

    /* renamed from: g  reason: collision with root package name */
    public UserBlockSetModel f61725g;

    /* renamed from: h  reason: collision with root package name */
    public UserBlockInfoModel f61726h;

    /* renamed from: i  reason: collision with root package name */
    public AdapterView.OnItemClickListener f61727i = new c();
    public View.OnClickListener j = new d();
    public View.OnClickListener k = new e();

    /* loaded from: classes5.dex */
    public class a implements d.a.n0.m.a<String> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.m.a
        /* renamed from: b */
        public void onSuccess(String str) {
            b.this.k();
            d.a.o0.o3.a.f((ViewGroup) b.this.f61719a.getPageActivity().findViewById(16908290), str, true);
        }

        @Override // d.a.n0.m.a
        public void onError(int i2, String str) {
            b.this.k();
            d.a.o0.o3.a.f((ViewGroup) b.this.f61719a.getPageActivity().findViewById(16908290), str, false);
        }
    }

    /* renamed from: d.a.o0.o3.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1517b implements d.a.n0.m.a {
        public C1517b() {
        }

        @Override // d.a.n0.m.a
        public void onError(int i2, String str) {
            if (b.this.f61719a != null) {
                b.this.f61719a.showToast(str);
            }
        }

        @Override // d.a.n0.m.a
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
            } else if (b.this.f61719a != null) {
                b.this.f61719a.showToast(R.string.error_unkown_try_again);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (((n) ListUtils.getItem(b.this.f61723e, i2)) != null) {
                b.this.f61722d.r(true);
            }
            b.this.f61722d.h(i2);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f61722d.d();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f61722d.d();
            if (b.this.f61723e == null || !j.z() || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return;
            }
            Iterator it = b.this.f61723e.iterator();
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
            b.this.f61725g.C(b.this.f61724f, i2, i3, i4);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements DialogInterface.OnCancelListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, b.this.f61720b);
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f61719a = tbPageContext;
        this.f61720b = bdUniqueId;
        UserBlockSetModel userBlockSetModel = new UserBlockSetModel(tbPageContext, bdUniqueId);
        this.f61725g = userBlockSetModel;
        userBlockSetModel.D(new a());
        UserBlockInfoModel userBlockInfoModel = new UserBlockInfoModel(tbPageContext, bdUniqueId);
        this.f61726h = userBlockInfoModel;
        userBlockInfoModel.D(new C1517b());
    }

    public final String j(int i2) {
        return TbadkCoreApplication.getInst().getString(i2);
    }

    public final void k() {
        d.a.n0.r.f0.a aVar = this.f61721c;
        if (aVar != null) {
            aVar.h(false);
        }
    }

    public void l() {
        this.f61724f = -1L;
        d.a.n0.r.f0.a aVar = this.f61721c;
        if (aVar != null) {
            aVar.h(false);
        }
        d.a.n0.r.s.f fVar = this.f61722d;
        if (fVar != null) {
            fVar.d();
        }
        UserBlockInfoModel userBlockInfoModel = this.f61726h;
        if (userBlockInfoModel != null) {
            userBlockInfoModel.onDestroy();
        }
        UserBlockSetModel userBlockSetModel = this.f61725g;
        if (userBlockSetModel != null) {
            userBlockSetModel.onDestroy();
        }
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_GET_USER_BLOCK_INFO, this.f61720b);
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, this.f61720b);
    }

    public final void m(int i2, PermissionList permissionList) {
        boolean z = false;
        boolean z2 = permissionList != null && permissionList.follow.intValue() == 1;
        boolean z3 = permissionList != null && permissionList.interact.intValue() == 1;
        if (permissionList != null && permissionList.chat.intValue() == 1) {
            z = true;
        }
        ArrayList<n> arrayList = new ArrayList<>();
        this.f61723e = arrayList;
        if (i2 == 1) {
            arrayList.add(new n(j(R.string.block_follow), z2, "1"));
            this.f61723e.add(new n(j(R.string.block_action), z3, "2"));
            this.f61723e.add(new n(j(R.string.block_message), z, "3"));
        } else {
            arrayList.add(new n(j(R.string.block_commit), z3, "2"));
            this.f61723e.add(new n(j(R.string.block_message), z, "3"));
        }
        d.a.n0.r.s.f fVar = new d.a.n0.r.s.f(this.f61719a);
        this.f61722d = fVar;
        fVar.l(R.string.block_user_title);
        this.f61722d.k(this.f61723e, this.f61727i);
        this.f61722d.q(R.string.done, this.k);
        this.f61722d.p(R.string.cancel, this.j);
        d.a.n0.r.s.f fVar2 = this.f61722d;
        fVar2.c();
        fVar2.n();
    }

    public void n(long j) {
        this.f61724f = j;
        this.f61726h.C(j);
    }

    public final void o() {
        if (this.f61721c == null) {
            d.a.n0.r.f0.a aVar = new d.a.n0.r.f0.a(this.f61719a);
            this.f61721c = aVar;
            aVar.e(new f());
        }
        this.f61721c.h(true);
    }
}
