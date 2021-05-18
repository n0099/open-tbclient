package d.a.k0.v3.u;

import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.tieba.write.write.WriteImageGridView;
import d.a.k0.v3.u.h;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<WriteActivity> f62928a;

    /* renamed from: b  reason: collision with root package name */
    public WriteImageGridView f62929b;

    /* renamed from: c  reason: collision with root package name */
    public WriteImagesInfo f62930c;

    /* renamed from: d  reason: collision with root package name */
    public h f62931d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.b0.b f62932e = new d.a.j0.b0.b();

    /* renamed from: f  reason: collision with root package name */
    public String f62933f = AlbumActivityConfig.FROM_WRITE;

    /* renamed from: g  reason: collision with root package name */
    public String f62934g = "";

    /* renamed from: h  reason: collision with root package name */
    public h.f f62935h = new a();

    /* loaded from: classes5.dex */
    public class a implements h.f {
        public a() {
        }

        @Override // d.a.k0.v3.u.h.f
        public void a(int i2) {
            if (i.this.f62930c == null || i.this.f62930c.getChosedFiles() == null || i2 < 0 || i2 >= i.this.f62930c.getChosedFiles().size()) {
                return;
            }
            ImageFileInfo remove = i.this.f62930c.getChosedFiles().remove(i2);
            if (remove.isTempFile()) {
                d.a.c.e.a.d.g().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            i iVar = i.this;
            iVar.f62931d.f(iVar.f62930c);
            i.this.f62931d.notifyDataSetChanged();
            if (ListUtils.isEmpty(i.this.f62930c.getChosedFiles()) && i.this.f62928a.getOrignalPage() != null) {
                ((WriteActivity) i.this.f62928a.getOrignalPage()).refreshPostButton();
            }
            if (i.this.f62928a.getPageActivity() instanceof WriteActivity) {
                ((WriteActivity) i.this.f62928a.getPageActivity()).refreshImageLauncher();
            }
        }

        @Override // d.a.k0.v3.u.h.f
        public void b() {
            if (i.this.f62930c == null) {
                return;
            }
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(i.this.f62928a.getPageActivity(), i.this.f62930c.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", i.this.f62934g);
            albumFloatActivityConfig.getIntent().putExtra("from", i.this.f62933f);
            albumFloatActivityConfig.setRequestCode(12002);
            if (i.this.f62928a.getPageActivity() instanceof WriteActivity) {
                albumFloatActivityConfig.setCanSelectVideo(((WriteActivity) i.this.f62928a.getPageActivity()).canSelectVideo());
                AntiData antiData = new AntiData();
                antiData.voice_message = ((WriteActivity) i.this.f62928a.getPageActivity()).mDisableAudioMessage;
                antiData.setIfVoice(((WriteActivity) i.this.f62928a.getPageActivity()).isVoiceEnable);
                albumFloatActivityConfig.setStatisticFrom(((WriteActivity) i.this.f62928a.getPageActivity()).mData.getStatisticFrom());
                albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) i.this.f62928a.getPageActivity()).mPrefixData, ((WriteActivity) i.this.f62928a.getPageActivity()).mData.getFirstDir(), ((WriteActivity) i.this.f62928a.getPageActivity()).mData.getSecondDir());
            }
            albumFloatActivityConfig.setFromWrite(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }

        @Override // d.a.k0.v3.u.h.f
        public void c(int i2) {
            int count;
            ImageFileInfo imageInfoAt;
            if (i.this.f62930c == null || (count = ListUtils.getCount(i.this.f62930c.getChosedFiles())) == 0 || i2 < 0 || i2 >= count || (imageInfoAt = i.this.f62930c.getImageInfoAt(i2)) == null || imageInfoAt.getImageType() == 1) {
                return;
            }
            i.this.f62928a.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(i.this.f62928a.getPageActivity(), 12012, i.this.f62930c, i2)));
        }
    }

    public i(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.f62928a = tbPageContext;
        this.f62929b = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        h hVar = new h(view.getContext(), this.f62932e, null, this.f62935h);
        this.f62931d = hVar;
        this.f62929b.setAdapter((ListAdapter) hVar);
    }

    public void e() {
        this.f62932e.b();
    }

    public GridView f() {
        return this.f62929b;
    }

    public void g(boolean z) {
        this.f62931d.g(z);
    }

    public void h(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.f62933f = str;
        this.f62934g = str2;
        this.f62930c = writeImagesInfo;
        this.f62931d.f(writeImagesInfo);
        this.f62931d.notifyDataSetChanged();
    }
}
