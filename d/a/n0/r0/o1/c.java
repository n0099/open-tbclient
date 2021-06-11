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
    public final ForumWriteData f62871a;

    /* renamed from: b  reason: collision with root package name */
    public final SerializableItemInfo f62872b;

    /* renamed from: c  reason: collision with root package name */
    public InputMethodManager f62873c;

    /* renamed from: d  reason: collision with root package name */
    public final BaseFragmentActivity f62874d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel f62875e;

    /* renamed from: f  reason: collision with root package name */
    public WriteData f62876f;

    /* renamed from: h  reason: collision with root package name */
    public b f62878h;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.r.f0.a f62877g = null;

    /* renamed from: i  reason: collision with root package name */
    public final NewWriteModel.g f62879i = new a();

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
                c.this.f62874d.showToast(postWriteCallBackData.getErrorString());
                return;
            }
            TiebaStatic.log(new StatisticItem("c13723").param("tid", postWriteCallBackData.getThreadId()).param("fid", c.this.f62871a.forumId).param("fname", c.this.f62871a.forumName).param("uid", TbadkCoreApplication.getCurrentAccount()));
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
            intent.putExtras(bundle);
            c.this.f62874d.setResult(-1, intent);
            c.this.f62874d.finish();
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.f62873c = null;
        this.f62874d = baseFragmentActivity;
        this.f62871a = forumWriteData;
        this.f62872b = serializableItemInfo;
        this.f62873c = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        e();
        d();
    }

    public void c() {
        this.f62877g.h(false);
    }

    public final void d() {
        this.f62875e = new NewWriteModel();
        this.f62876f = new WriteData();
        this.f62875e.h0(this.f62879i);
    }

    public final void e() {
        this.f62877g = new d.a.m0.r.f0.a(this.f62874d);
    }

    public final void f() {
        this.f62875e.j0(this.f62876f);
        this.f62875e.m0();
        i();
    }

    public void g(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.z()) {
            l.L(this.f62874d, R.string.neterror);
        }
        SerializableItemInfo serializableItemInfo = this.f62872b;
        if (serializableItemInfo != null) {
            this.f62876f.setItem_id(String.valueOf(serializableItemInfo.id));
        }
        this.f62876f.setForumName(forumWriteData.forumName);
        this.f62876f.setContent(str);
        this.f62876f.setComment_head(str2);
        this.f62876f.setForumId(forumWriteData.forumId);
        this.f62876f.setTitle("");
        this.f62876f.setIsNoTitle(true);
        b bVar = this.f62878h;
        if (bVar != null) {
            bVar.a(this.f62873c);
        }
        f();
    }

    public void h(b bVar) {
        this.f62878h = bVar;
    }

    public void i() {
        this.f62877g.e(null);
        this.f62877g.i(R.string.sending);
        this.f62877g.h(true);
    }
}
