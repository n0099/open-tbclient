package d.a.n0.r0.o1;

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
import d.a.m0.s.c.i0;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final ForumWriteData f59180a;

    /* renamed from: b  reason: collision with root package name */
    public final SerializableItemInfo f59181b;

    /* renamed from: c  reason: collision with root package name */
    public InputMethodManager f59182c;

    /* renamed from: d  reason: collision with root package name */
    public final BaseFragmentActivity f59183d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel f59184e;

    /* renamed from: f  reason: collision with root package name */
    public WriteData f59185f;

    /* renamed from: h  reason: collision with root package name */
    public b f59187h;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.r.f0.a f59186g = null;

    /* renamed from: i  reason: collision with root package name */
    public final NewWriteModel.g f59188i = new a();

    /* loaded from: classes4.dex */
    public class a implements NewWriteModel.g {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData) {
            c.this.c();
            if (postWriteCallBackData == null) {
                return;
            }
            if (!z) {
                c.this.f59183d.showToast(postWriteCallBackData.getErrorString());
                return;
            }
            TiebaStatic.log(new StatisticItem("c13723").param("tid", postWriteCallBackData.getThreadId()).param("fid", c.this.f59180a.forumId).param("fname", c.this.f59180a.forumName).param("uid", TbadkCoreApplication.getCurrentAccount()));
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
            intent.putExtras(bundle);
            c.this.f59183d.setResult(-1, intent);
            c.this.f59183d.finish();
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.f59182c = null;
        this.f59183d = baseFragmentActivity;
        this.f59180a = forumWriteData;
        this.f59181b = serializableItemInfo;
        this.f59182c = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        e();
        d();
    }

    public void c() {
        this.f59186g.h(false);
    }

    public final void d() {
        this.f59184e = new NewWriteModel();
        this.f59185f = new WriteData();
        this.f59184e.d0(this.f59188i);
    }

    public final void e() {
        this.f59186g = new d.a.m0.r.f0.a(this.f59183d);
    }

    public final void f() {
        this.f59184e.f0(this.f59185f);
        this.f59184e.i0();
        i();
    }

    public void g(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.z()) {
            l.L(this.f59183d, R.string.neterror);
        }
        SerializableItemInfo serializableItemInfo = this.f59181b;
        if (serializableItemInfo != null) {
            this.f59185f.setItem_id(String.valueOf(serializableItemInfo.id));
        }
        this.f59185f.setForumName(forumWriteData.forumName);
        this.f59185f.setContent(str);
        this.f59185f.setComment_head(str2);
        this.f59185f.setForumId(forumWriteData.forumId);
        this.f59185f.setTitle("");
        this.f59185f.setIsNoTitle(true);
        b bVar = this.f59187h;
        if (bVar != null) {
            bVar.a(this.f59182c);
        }
        f();
    }

    public void h(b bVar) {
        this.f59187h = bVar;
    }

    public void i() {
        this.f59186g.e(null);
        this.f59186g.i(R.string.sending);
        this.f59186g.h(true);
    }
}
