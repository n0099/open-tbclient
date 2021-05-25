package d.a.n0.m3;

import android.app.Activity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.ueg.UEGCancelModel;
import d.a.c.a.g;
import d.a.c.e.p.k;
import d.a.m0.r.s.a;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static boolean f57462d = false;

    /* renamed from: b  reason: collision with root package name */
    public UEGCancelModel.b f57464b;

    /* renamed from: c  reason: collision with root package name */
    public int f57465c = TbadkCoreStatisticKey.AntiLocateValue.LOCATE_COLD_BOOT;

    /* renamed from: a  reason: collision with root package name */
    public UEGCancelModel f57463a = new UEGCancelModel();

    /* loaded from: classes5.dex */
    public class a implements UEGCancelModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.ueg.UEGCancelModel.b
        public void a(BlockPopInfoData blockPopInfoData) {
            if (blockPopInfoData == null || b.f57462d) {
                return;
            }
            b.this.d(blockPopInfoData);
        }
    }

    /* renamed from: d.a.n0.m3.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1439b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BlockPopInfoData f57467e;

        public C1439b(BlockPopInfoData blockPopInfoData) {
            this.f57467e = blockPopInfoData;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", b.this.f57465c).param("obj_type", this.f57467e.win_type));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BlockPopInfoData f57469e;

        public c(BlockPopInfoData blockPopInfoData) {
            this.f57469e = blockPopInfoData;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            b.this.e(this.f57469e);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", b.this.f57465c).param("obj_type", this.f57469e.win_type));
        }
    }

    public b() {
        if (this.f57464b == null) {
            this.f57464b = new a();
        }
        this.f57463a.u(this.f57464b);
    }

    public void c(int i2) {
        this.f57465c = i2;
        this.f57463a.t();
    }

    public final void d(BlockPopInfoData blockPopInfoData) {
        if (blockPopInfoData == null || d.a.c.a.b.f().b() == null) {
            return;
        }
        String str = blockPopInfoData.block_id_code;
        int i2 = blockPopInfoData.win_type;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str2 = blockPopInfoData.ahead_url;
        String str3 = blockPopInfoData.ok_info;
        String str4 = blockPopInfoData.ahead_info;
        String str5 = blockPopInfoData.block_info;
        if ((i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4) || k.isEmpty(currentAccount) || k.isEmpty(str)) {
            return;
        }
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        boolean z = false;
        boolean g2 = j.g(str + i2 + currentAccount, false);
        if ((!k.isEmpty(str2) || i2 == 4) && !k.isEmpty(str3) && ((!k.isEmpty(str4) || i2 == 4) && !k.isEmpty(str5))) {
            z = true;
        }
        if (g2 || !z) {
            return;
        }
        d.a.m0.r.d0.b j2 = d.a.m0.r.d0.b.j();
        j2.t(str + i2 + currentAccount, true);
        h(blockPopInfoData);
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", this.f57465c).param("obj_type", i2));
    }

    public final void e(BlockPopInfoData blockPopInfoData) {
        Activity b2;
        if (blockPopInfoData == null || (b2 = d.a.c.a.b.f().b()) == null) {
            return;
        }
        AntiHelper.p(b2, blockPopInfoData.ahead_url);
    }

    public void f() {
        UEGCancelModel uEGCancelModel = this.f57463a;
        if (uEGCancelModel != null) {
            uEGCancelModel.onDestroy();
        }
    }

    public void g(boolean z) {
        f57462d = z;
    }

    public final void h(BlockPopInfoData blockPopInfoData) {
        Activity b2;
        if (blockPopInfoData == null || (b2 = d.a.c.a.b.f().b()) == null) {
            return;
        }
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(b2);
        aVar.setMessage(blockPopInfoData.block_info);
        aVar.setNegativeButton(blockPopInfoData.ok_info, new C1439b(blockPopInfoData));
        aVar.setPositiveButton(blockPopInfoData.ahead_info, new c(blockPopInfoData));
        aVar.create(((g) b2).getPageContext());
        aVar.show();
    }
}
