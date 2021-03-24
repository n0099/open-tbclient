package d.b.i0.m3;

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
import d.b.b.e.p.j;
import d.b.h0.r.s.n;
import java.util.ArrayList;
import java.util.Iterator;
import tbclient.GetUserBlackInfo.DataRes;
import tbclient.PermissionList;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56944a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f56945b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.h0.r.f0.a f56946c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.r.s.f f56947d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f56948e;

    /* renamed from: f  reason: collision with root package name */
    public long f56949f;

    /* renamed from: g  reason: collision with root package name */
    public UserBlockSetModel f56950g;

    /* renamed from: h  reason: collision with root package name */
    public UserBlockInfoModel f56951h;
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
            d.b.i0.m3.a.f((ViewGroup) b.this.f56944a.getPageActivity().findViewById(16908290), str, true);
        }

        @Override // d.b.h0.m.a
        public void onError(int i, String str) {
            b.this.k();
            d.b.i0.m3.a.f((ViewGroup) b.this.f56944a.getPageActivity().findViewById(16908290), str, false);
        }
    }

    /* renamed from: d.b.i0.m3.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1348b implements d.b.h0.m.a {
        public C1348b() {
        }

        @Override // d.b.h0.m.a
        public void onError(int i, String str) {
            if (b.this.f56944a != null) {
                b.this.f56944a.showToast(str);
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
            } else if (b.this.f56944a != null) {
                b.this.f56944a.showToast(R.string.error_unkown_try_again);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (((n) ListUtils.getItem(b.this.f56948e, i)) != null) {
                b.this.f56947d.r(true);
            }
            b.this.f56947d.h(i);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f56947d.d();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f56947d.d();
            if (b.this.f56948e == null || !j.z() || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return;
            }
            Iterator it = b.this.f56948e.iterator();
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
            b.this.f56950g.y(b.this.f56949f, i, i2, i3);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements DialogInterface.OnCancelListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, b.this.f56945b);
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f56944a = tbPageContext;
        this.f56945b = bdUniqueId;
        UserBlockSetModel userBlockSetModel = new UserBlockSetModel(tbPageContext, bdUniqueId);
        this.f56950g = userBlockSetModel;
        userBlockSetModel.z(new a());
        UserBlockInfoModel userBlockInfoModel = new UserBlockInfoModel(tbPageContext, bdUniqueId);
        this.f56951h = userBlockInfoModel;
        userBlockInfoModel.z(new C1348b());
    }

    public final String j(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public final void k() {
        d.b.h0.r.f0.a aVar = this.f56946c;
        if (aVar != null) {
            aVar.h(false);
        }
    }

    public void l() {
        this.f56949f = -1L;
        d.b.h0.r.f0.a aVar = this.f56946c;
        if (aVar != null) {
            aVar.h(false);
        }
        d.b.h0.r.s.f fVar = this.f56947d;
        if (fVar != null) {
            fVar.d();
        }
        UserBlockInfoModel userBlockInfoModel = this.f56951h;
        if (userBlockInfoModel != null) {
            userBlockInfoModel.onDestroy();
        }
        UserBlockSetModel userBlockSetModel = this.f56950g;
        if (userBlockSetModel != null) {
            userBlockSetModel.onDestroy();
        }
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_GET_USER_BLOCK_INFO, this.f56945b);
        MessageManager.getInstance().removeMessage(CmdConfigHttp.CMD_USER_BLOCK_SET, this.f56945b);
    }

    public final void m(int i, PermissionList permissionList) {
        boolean z = false;
        boolean z2 = permissionList != null && permissionList.follow.intValue() == 1;
        boolean z3 = permissionList != null && permissionList.interact.intValue() == 1;
        if (permissionList != null && permissionList.chat.intValue() == 1) {
            z = true;
        }
        ArrayList<n> arrayList = new ArrayList<>();
        this.f56948e = arrayList;
        if (i == 1) {
            arrayList.add(new n(j(R.string.block_follow), z2, "1"));
            this.f56948e.add(new n(j(R.string.block_action), z3, "2"));
            this.f56948e.add(new n(j(R.string.block_message), z, "3"));
        } else {
            arrayList.add(new n(j(R.string.block_commit), z3, "2"));
            this.f56948e.add(new n(j(R.string.block_message), z, "3"));
        }
        d.b.h0.r.s.f fVar = new d.b.h0.r.s.f(this.f56944a);
        this.f56947d = fVar;
        fVar.l(R.string.block_user_title);
        this.f56947d.k(this.f56948e, this.i);
        this.f56947d.q(R.string.done, this.k);
        this.f56947d.p(R.string.cancel, this.j);
        d.b.h0.r.s.f fVar2 = this.f56947d;
        fVar2.c();
        fVar2.n();
    }

    public void n(long j) {
        this.f56949f = j;
        this.f56951h.y(j);
    }

    public final void o() {
        if (this.f56946c == null) {
            d.b.h0.r.f0.a aVar = new d.b.h0.r.f0.a(this.f56944a);
            this.f56946c = aVar;
            aVar.e(new f());
        }
        this.f56946c.h(true);
    }
}
