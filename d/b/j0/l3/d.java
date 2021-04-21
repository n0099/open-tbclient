package d.b.j0.l3;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.b.c.e.p.k;
import d.b.i0.r.s.a;
import tbclient.BlockPopInfo;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static BlockPopInfo f58567c;

    /* renamed from: d  reason: collision with root package name */
    public static BlockPopInfo f58568d;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58569a;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f58570b;

    /* loaded from: classes5.dex */
    public class a implements a.e {
        public a(d dVar) {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BlockPopInfo f58571e;

        public b(BlockPopInfo blockPopInfo) {
            this.f58571e = blockPopInfo;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            d.this.e(this.f58571e);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public c(d dVar, int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            d.g(null);
            d.f(null);
        }
    }

    public d(TbPageContext tbPageContext) {
        c cVar = new c(this, 2005016);
        this.f58570b = cVar;
        this.f58569a = tbPageContext;
        tbPageContext.registerListener(cVar);
    }

    public static void f(BlockPopInfo blockPopInfo) {
        f58568d = blockPopInfo;
    }

    public static void g(BlockPopInfo blockPopInfo) {
        f58567c = blockPopInfo;
    }

    public final boolean b(BlockPopInfo blockPopInfo) {
        Integer num;
        if (blockPopInfo != null && (num = blockPopInfo.appeal_status) != null && num.intValue() == 1) {
            BdToast.h(this.f58569a.getPageActivity(), blockPopInfo.appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, false).q();
            return true;
        } else if (blockPopInfo == null || blockPopInfo.can_post.intValue() != 0 || (!(blockPopInfo.ahead_type.intValue() == 1 || blockPopInfo.ahead_type.intValue() == 2) || blockPopInfo.appeal_status.intValue() == 1)) {
            return false;
        } else {
            if (blockPopInfo.ahead_type.intValue() == 1) {
                String str = blockPopInfo.block_info;
                String str2 = blockPopInfo.ok_info;
                if (!k.isEmpty(str) && !k.isEmpty(str2)) {
                    h(blockPopInfo);
                } else {
                    BdToast.h(this.f58569a.getPageActivity(), this.f58569a.getString(R.string.hanpen_error), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).q();
                }
            } else if (blockPopInfo.ahead_type.intValue() == 2) {
                e(blockPopInfo);
            }
            return true;
        }
    }

    public boolean c() {
        return b(f58568d);
    }

    public boolean d() {
        return b(f58567c);
    }

    public final void e(BlockPopInfo blockPopInfo) {
        if (blockPopInfo == null) {
            return;
        }
        AntiHelper.p(this.f58569a.getPageActivity(), blockPopInfo.ahead_url);
    }

    public final void h(BlockPopInfo blockPopInfo) {
        if (blockPopInfo == null) {
            return;
        }
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.f58569a.getPageActivity());
        aVar.setMessage(blockPopInfo.block_info);
        aVar.setNegativeButton(blockPopInfo.ok_info, new a(this));
        aVar.setPositiveButton(blockPopInfo.ahead_info, new b(blockPopInfo));
        aVar.create(this.f58569a).show();
    }
}
