package d.a.k0.q0.o1;

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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.j0.s.c.h0;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final ForumWriteData f59039a;

    /* renamed from: b  reason: collision with root package name */
    public final SerializableItemInfo f59040b;

    /* renamed from: c  reason: collision with root package name */
    public InputMethodManager f59041c;

    /* renamed from: d  reason: collision with root package name */
    public final BaseFragmentActivity f59042d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel f59043e;

    /* renamed from: f  reason: collision with root package name */
    public WriteData f59044f;

    /* renamed from: h  reason: collision with root package name */
    public b f59046h;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.r.f0.a f59045g = null;

    /* renamed from: i  reason: collision with root package name */
    public final NewWriteModel.g f59047i = new a();

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
                c.this.f59042d.showToast(postWriteCallBackData.getErrorString());
                return;
            }
            TiebaStatic.log(new StatisticItem("c13723").param("tid", postWriteCallBackData.getThreadId()).param("fid", c.this.f59039a.forumId).param("fname", c.this.f59039a.forumName).param("uid", TbadkCoreApplication.getCurrentAccount()));
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
            intent.putExtras(bundle);
            c.this.f59042d.setResult(-1, intent);
            c.this.f59042d.finish();
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.f59041c = null;
        this.f59042d = baseFragmentActivity;
        this.f59039a = forumWriteData;
        this.f59040b = serializableItemInfo;
        this.f59041c = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        e();
        d();
    }

    public void c() {
        this.f59045g.h(false);
    }

    public final void d() {
        this.f59043e = new NewWriteModel();
        this.f59044f = new WriteData();
        this.f59043e.d0(this.f59047i);
    }

    public final void e() {
        this.f59045g = new d.a.j0.r.f0.a(this.f59042d);
    }

    public final void f() {
        this.f59043e.f0(this.f59044f);
        this.f59043e.i0();
        i();
    }

    public void g(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.z()) {
            l.L(this.f59042d, R.string.neterror);
        }
        SerializableItemInfo serializableItemInfo = this.f59040b;
        if (serializableItemInfo != null) {
            this.f59044f.setItem_id(String.valueOf(serializableItemInfo.id));
        }
        this.f59044f.setForumName(forumWriteData.forumName);
        this.f59044f.setContent(str);
        this.f59044f.setComment_head(str2);
        this.f59044f.setForumId(forumWriteData.forumId);
        this.f59044f.setTitle("");
        this.f59044f.setIsNoTitle(true);
        b bVar = this.f59046h;
        if (bVar != null) {
            bVar.a(this.f59041c);
        }
        f();
    }

    public void h(b bVar) {
        this.f59046h = bVar;
    }

    public void i() {
        this.f59045g.e(null);
        this.f59045g.i(R.string.sending);
        this.f59045g.h(true);
    }
}
