package d.b.i0.l3;

import android.app.Activity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.ueg.UEGCancelModel;
import d.b.c.a.g;
import d.b.c.e.p.k;
import d.b.h0.r.s.a;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static boolean f58135d = false;

    /* renamed from: b  reason: collision with root package name */
    public UEGCancelModel.b f58137b;

    /* renamed from: c  reason: collision with root package name */
    public int f58138c = TbadkCoreStatisticKey.AntiLocateValue.LOCATE_COLD_BOOT;

    /* renamed from: a  reason: collision with root package name */
    public UEGCancelModel f58136a = new UEGCancelModel();

    /* loaded from: classes5.dex */
    public class a implements UEGCancelModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.ueg.UEGCancelModel.b
        public void a(BlockPopInfoData blockPopInfoData) {
            if (blockPopInfoData == null || b.f58135d) {
                return;
            }
            b.this.d(blockPopInfoData);
        }
    }

    /* renamed from: d.b.i0.l3.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1387b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BlockPopInfoData f58140e;

        public C1387b(BlockPopInfoData blockPopInfoData) {
            this.f58140e = blockPopInfoData;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", b.this.f58138c).param("obj_type", this.f58140e.win_type));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BlockPopInfoData f58142e;

        public c(BlockPopInfoData blockPopInfoData) {
            this.f58142e = blockPopInfoData;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            b.this.e(this.f58142e);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", b.this.f58138c).param("obj_type", this.f58142e.win_type));
        }
    }

    public b() {
        if (this.f58137b == null) {
            this.f58137b = new a();
        }
        this.f58136a.u(this.f58137b);
    }

    public void c(int i) {
        this.f58138c = i;
        this.f58136a.t();
    }

    public final void d(BlockPopInfoData blockPopInfoData) {
        if (blockPopInfoData == null || d.b.c.a.b.f().b() == null) {
            return;
        }
        String str = blockPopInfoData.block_id_code;
        int i = blockPopInfoData.win_type;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str2 = blockPopInfoData.ahead_url;
        String str3 = blockPopInfoData.ok_info;
        String str4 = blockPopInfoData.ahead_info;
        String str5 = blockPopInfoData.block_info;
        if ((i != 1 && i != 2 && i != 3 && i != 4) || k.isEmpty(currentAccount) || k.isEmpty(str)) {
            return;
        }
        d.b.h0.r.d0.b j = d.b.h0.r.d0.b.j();
        boolean z = false;
        boolean g2 = j.g(str + i + currentAccount, false);
        if ((!k.isEmpty(str2) || i == 4) && !k.isEmpty(str3) && ((!k.isEmpty(str4) || i == 4) && !k.isEmpty(str5))) {
            z = true;
        }
        if (g2 || !z) {
            return;
        }
        d.b.h0.r.d0.b j2 = d.b.h0.r.d0.b.j();
        j2.t(str + i + currentAccount, true);
        h(blockPopInfoData);
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", this.f58138c).param("obj_type", i));
    }

    public final void e(BlockPopInfoData blockPopInfoData) {
        Activity b2;
        if (blockPopInfoData == null || (b2 = d.b.c.a.b.f().b()) == null) {
            return;
        }
        AntiHelper.p(b2, blockPopInfoData.ahead_url);
    }

    public void f() {
        UEGCancelModel uEGCancelModel = this.f58136a;
        if (uEGCancelModel != null) {
            uEGCancelModel.onDestroy();
        }
    }

    public void g(boolean z) {
        f58135d = z;
    }

    public final void h(BlockPopInfoData blockPopInfoData) {
        Activity b2;
        if (blockPopInfoData == null || (b2 = d.b.c.a.b.f().b()) == null) {
            return;
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(b2);
        aVar.setMessage(blockPopInfoData.block_info);
        aVar.setNegativeButton(blockPopInfoData.ok_info, new C1387b(blockPopInfoData));
        aVar.setPositiveButton(blockPopInfoData.ahead_info, new c(blockPopInfoData));
        aVar.create(((g) b2).getPageContext());
        aVar.show();
    }
}
