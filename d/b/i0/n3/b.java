package d.b.i0.n3;

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
import d.b.c.e.p.j;
import d.b.h0.r.s.n;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.GetUserBlackInfo.DataRes;
import tbclient.PermissionList;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58582a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f58583b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.h0.r.f0.a f58584c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.r.s.f f58585d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f58586e;

    /* renamed from: f  reason: collision with root package name */
    public long f58587f;

    /* renamed from: g  reason: collision with root package name */
    public UserBlockSetModel f58588g;

    /* renamed from: h  reason: collision with root package name */
    public UserBlockInfoModel f58589h;
    public AdapterView.OnItemClickListener i = new c();
    public View.OnClickListener j = new d();
    public View.OnClickListener k = new e();

    /* loaded from: classes5.dex */
    public class a implements d.b.h0.m.a<String> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.m.a
        /* renamed from: b */
        public void onSuccess(String str) {
            b.this.k();
            d.b.i0.n3.a.f((ViewGroup) b.this.f58582a.getPageActivity().findViewById(16908290), str, true);
        }

        @Override // d.b.h0.m.a
        public void onError(int i, String str) {
            b.this.k();
            d.b.i0.n3.a.f((ViewGroup) b.this.f58582a.getPageActivity().findViewById(16908290), str, false);
        }
    }

    /* renamed from: d.b.i0.n3.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1407b implements d.b.h0.m.a {
        public C1407b() {
        }

        @Override // d.b.h0.m.a
        public void onError(int i, String str) {
            if (b.this.f58582a != null) {
                b.this.f58582a.showToast(str);
            }
        }

        @Override // d.b.h0.m.a
        public void onSuccess(Object obj) {
            int i;
            PermissionList permissionList;
            if (obj instanceof DataRes) {
                DataRes dataRes = (DataRes) obj;
                i = dataRes.is_black_white.intValue();
                permissionList = dataRes.perm_list;
            } else {
                i = 0;
                permissionList = null;
            }
            if (permissionList != null) {
                b.this.m(i, permissionList);
            } else if (b.this.f58582a != null) {
                b.this.f58582a.showToast(R.string.error_unkown_try_again);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (((n) ListUtils.getItem(b.this.f58586e, i)) != null) {
                b.this.f58585d.r(true);
            }
            b.this.f58585d.h(i);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f58585d.d();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f58585d.d();
            if (b.this.f58586e == null || !j.z() || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return;
            }
            Iterator it = b.this.f58586e.iterator();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                n nVar = (n) it.next();
                if (nVar.d() && "1".equals(nVar.b())) {
                    i = 1;
                } else if (nVar.d() && "2".equals(nVar.b())) {
                    i2 = 1;
                } else if (nVar.d() && "3".equals(nVar.b())) {
                    i3 = 1;
                }
            }
            b.this.o();
            b.this.f58588g.y(b.this.f58587f, i, i2, i3);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements DialogInterface.OnCancelListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, b.this.f58583b);
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f58582a = tbPageContext;
        this.f58583b = bdUniqueId;
        UserBlockSetModel userBlockSetModel = new UserBlockSetModel(tbPageContext, bdUniqueId);
        this.f58588g = userBlockSetModel;
        userBlockSetModel.z(new a());
        UserBlockInfoModel userBlockInfoModel = new UserBlockInfoModel(tbPageContext, bdUniqueId);
        this.f58589h = userBlockInfoModel;
        userBlockInfoModel.z(new C1407b());
    }

    public final String j(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public final void k() {
        d.b.h0.r.f0.a aVar = this.f58584c;
        if (aVar != null) {
            aVar.h(false);
        }
    }

    public void l() {
        this.f58587f = -1L;
        d.b.h0.r.f0.a aVar = this.f58584c;
        if (aVar != null) {
            aVar.h(false);
        }
        d.b.h0.r.s.f fVar = this.f58585d;
        if (fVar != null) {
            fVar.d();
        }
        UserBlockInfoModel userBlockInfoModel = this.f58589h;
        if (userBlockInfoModel != null) {
            userBlockInfoModel.onDestroy();
        }
        UserBlockSetModel userBlockSetModel = this.f58588g;
        if (userBlockSetModel != null) {
            userBlockSetModel.onDestroy();
        }
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_GET_USER_BLOCK_INFO, this.f58583b);
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, this.f58583b);
    }

    public final void m(int i, PermissionList permissionList) {
        boolean z = false;
        boolean z2 = permissionList != null && permissionList.follow.intValue() == 1;
        boolean z3 = permissionList != null && permissionList.interact.intValue() == 1;
        if (permissionList != null && permissionList.chat.intValue() == 1) {
            z = true;
        }
        ArrayList<n> arrayList = new ArrayList<>();
        this.f58586e = arrayList;
        if (i == 1) {
            arrayList.add(new n(j(R.string.block_follow), z2, "1"));
            this.f58586e.add(new n(j(R.string.block_action), z3, "2"));
            this.f58586e.add(new n(j(R.string.block_message), z, "3"));
        } else {
            arrayList.add(new n(j(R.string.block_commit), z3, "2"));
            this.f58586e.add(new n(j(R.string.block_message), z, "3"));
        }
        d.b.h0.r.s.f fVar = new d.b.h0.r.s.f(this.f58582a);
        this.f58585d = fVar;
        fVar.l(R.string.block_user_title);
        this.f58585d.k(this.f58586e, this.i);
        this.f58585d.q(R.string.done, this.k);
        this.f58585d.p(R.string.cancel, this.j);
        d.b.h0.r.s.f fVar2 = this.f58585d;
        fVar2.c();
        fVar2.n();
    }

    public void n(long j) {
        this.f58587f = j;
        this.f58589h.y(j);
    }

    public final void o() {
        if (this.f58584c == null) {
            d.b.h0.r.f0.a aVar = new d.b.h0.r.f0.a(this.f58582a);
            this.f58584c = aVar;
            aVar.e(new f());
        }
        this.f58584c.h(true);
    }
}
