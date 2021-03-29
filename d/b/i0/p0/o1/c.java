package d.b.i0.p0.o1;

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
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.h0.s.c.f0;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final ForumWriteData f58254a;

    /* renamed from: b  reason: collision with root package name */
    public final SerializableItemInfo f58255b;

    /* renamed from: c  reason: collision with root package name */
    public InputMethodManager f58256c;

    /* renamed from: d  reason: collision with root package name */
    public final BaseFragmentActivity f58257d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel f58258e;

    /* renamed from: f  reason: collision with root package name */
    public WriteData f58259f;

    /* renamed from: h  reason: collision with root package name */
    public b f58261h;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.f0.a f58260g = null;
    public final NewWriteModel.g i = new a();

    /* loaded from: classes4.dex */
    public class a implements NewWriteModel.g {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, f0 f0Var, WriteData writeData, AntiData antiData) {
            c.this.c();
            if (postWriteCallBackData == null) {
                return;
            }
            if (!z) {
                c.this.f58257d.showToast(postWriteCallBackData.getErrorString());
                return;
            }
            TiebaStatic.log(new StatisticItem("c13723").param("tid", postWriteCallBackData.getThreadId()).param("fid", c.this.f58254a.forumId).param("fname", c.this.f58254a.forumName).param("uid", TbadkCoreApplication.getCurrentAccount()));
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
            intent.putExtras(bundle);
            c.this.f58257d.setResult(-1, intent);
            c.this.f58257d.finish();
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.f58256c = null;
        this.f58257d = baseFragmentActivity;
        this.f58254a = forumWriteData;
        this.f58255b = serializableItemInfo;
        this.f58256c = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        e();
        d();
    }

    public void c() {
        this.f58260g.h(false);
    }

    public final void d() {
        this.f58258e = new NewWriteModel();
        this.f58259f = new WriteData();
        this.f58258e.d0(this.i);
    }

    public final void e() {
        this.f58260g = new d.b.h0.r.f0.a(this.f58257d);
    }

    public final void f() {
        this.f58258e.f0(this.f58259f);
        this.f58258e.i0();
        i();
    }

    public void g(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.z()) {
            l.K(this.f58257d, R.string.neterror);
        }
        SerializableItemInfo serializableItemInfo = this.f58255b;
        if (serializableItemInfo != null) {
            this.f58259f.setItem_id(String.valueOf(serializableItemInfo.id));
        }
        this.f58259f.setForumName(forumWriteData.forumName);
        this.f58259f.setContent(str);
        this.f58259f.setComment_head(str2);
        this.f58259f.setForumId(forumWriteData.forumId);
        this.f58259f.setTitle("");
        this.f58259f.setIsNoTitle(true);
        b bVar = this.f58261h;
        if (bVar != null) {
            bVar.a(this.f58256c);
        }
        f();
    }

    public void h(b bVar) {
        this.f58261h = bVar;
    }

    public void i() {
        this.f58260g.e(null);
        this.f58260g.i(R.string.sending);
        this.f58260g.h(true);
    }
}
