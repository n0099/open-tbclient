package d.b.j0.q0.o1;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.i0.s.c.h0;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final ForumWriteData f60214a;

    /* renamed from: b  reason: collision with root package name */
    public final SerializableItemInfo f60215b;

    /* renamed from: c  reason: collision with root package name */
    public InputMethodManager f60216c;

    /* renamed from: d  reason: collision with root package name */
    public final BaseFragmentActivity f60217d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel f60218e;

    /* renamed from: f  reason: collision with root package name */
    public WriteData f60219f;

    /* renamed from: h  reason: collision with root package name */
    public b f60221h;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.r.f0.a f60220g = null;
    public final NewWriteModel.g i = new a();

    /* loaded from: classes4.dex */
    public class a implements NewWriteModel.g {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, h0 h0Var, WriteData writeData, AntiData antiData) {
            c.this.c();
            if (postWriteCallBackData == null) {
                return;
            }
            if (!z) {
                c.this.f60217d.showToast(postWriteCallBackData.getErrorString());
                return;
            }
            TiebaStatic.log(new StatisticItem("c13723").param("tid", postWriteCallBackData.getThreadId()).param("fid", c.this.f60214a.forumId).param("fname", c.this.f60214a.forumName).param("uid", TbadkCoreApplication.getCurrentAccount()));
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
            intent.putExtras(bundle);
            c.this.f60217d.setResult(-1, intent);
            c.this.f60217d.finish();
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.f60216c = null;
        this.f60217d = baseFragmentActivity;
        this.f60214a = forumWriteData;
        this.f60215b = serializableItemInfo;
        this.f60216c = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        e();
        d();
    }

    public void c() {
        this.f60220g.h(false);
    }

    public final void d() {
        this.f60218e = new NewWriteModel();
        this.f60219f = new WriteData();
        this.f60218e.d0(this.i);
    }

    public final void e() {
        this.f60220g = new d.b.i0.r.f0.a(this.f60217d);
    }

    public final void f() {
        this.f60218e.f0(this.f60219f);
        this.f60218e.i0();
        i();
    }

    public void g(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.z()) {
            l.K(this.f60217d, R.string.neterror);
        }
        SerializableItemInfo serializableItemInfo = this.f60215b;
        if (serializableItemInfo != null) {
            this.f60219f.setItem_id(String.valueOf(serializableItemInfo.id));
        }
        this.f60219f.setForumName(forumWriteData.forumName);
        this.f60219f.setContent(str);
        this.f60219f.setComment_head(str2);
        this.f60219f.setForumId(forumWriteData.forumId);
        this.f60219f.setTitle("");
        this.f60219f.setIsNoTitle(true);
        b bVar = this.f60221h;
        if (bVar != null) {
            bVar.a(this.f60216c);
        }
        f();
    }

    public void h(b bVar) {
        this.f60221h = bVar;
    }

    public void i() {
        this.f60220g.e(null);
        this.f60220g.i(R.string.sending);
        this.f60220g.h(true);
    }
}
