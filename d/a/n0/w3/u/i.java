package d.a.n0.w3.u;

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
import d.a.n0.w3.u.h;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<WriteActivity> f63037a;

    /* renamed from: b  reason: collision with root package name */
    public WriteImageGridView f63038b;

    /* renamed from: c  reason: collision with root package name */
    public WriteImagesInfo f63039c;

    /* renamed from: d  reason: collision with root package name */
    public h f63040d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.b0.b f63041e = new d.a.m0.b0.b();

    /* renamed from: f  reason: collision with root package name */
    public String f63042f = AlbumActivityConfig.FROM_WRITE;

    /* renamed from: g  reason: collision with root package name */
    public String f63043g = "";

    /* renamed from: h  reason: collision with root package name */
    public h.f f63044h = new a();

    /* loaded from: classes5.dex */
    public class a implements h.f {
        public a() {
        }

        @Override // d.a.n0.w3.u.h.f
        public void a(int i2) {
            if (i.this.f63039c == null || i.this.f63039c.getChosedFiles() == null || i2 < 0 || i2 >= i.this.f63039c.getChosedFiles().size()) {
                return;
            }
            ImageFileInfo remove = i.this.f63039c.getChosedFiles().remove(i2);
            if (remove.isTempFile()) {
                d.a.c.e.a.d.g().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            i iVar = i.this;
            iVar.f63040d.f(iVar.f63039c);
            i.this.f63040d.notifyDataSetChanged();
            if (ListUtils.isEmpty(i.this.f63039c.getChosedFiles()) && i.this.f63037a.getOrignalPage() != null) {
                ((WriteActivity) i.this.f63037a.getOrignalPage()).refreshPostButton();
            }
            if (i.this.f63037a.getPageActivity() instanceof WriteActivity) {
                ((WriteActivity) i.this.f63037a.getPageActivity()).refreshImageLauncher();
            }
        }

        @Override // d.a.n0.w3.u.h.f
        public void b() {
            if (i.this.f63039c == null) {
                return;
            }
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(i.this.f63037a.getPageActivity(), i.this.f63039c.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", i.this.f63043g);
            albumFloatActivityConfig.getIntent().putExtra("from", i.this.f63042f);
            albumFloatActivityConfig.setRequestCode(12002);
            if (i.this.f63037a.getPageActivity() instanceof WriteActivity) {
                albumFloatActivityConfig.setCanSelectVideo(((WriteActivity) i.this.f63037a.getPageActivity()).canSelectVideo());
                AntiData antiData = new AntiData();
                antiData.voice_message = ((WriteActivity) i.this.f63037a.getPageActivity()).mDisableAudioMessage;
                antiData.setIfVoice(((WriteActivity) i.this.f63037a.getPageActivity()).isVoiceEnable);
                albumFloatActivityConfig.setStatisticFrom(((WriteActivity) i.this.f63037a.getPageActivity()).mData.getStatisticFrom());
                albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) i.this.f63037a.getPageActivity()).mPrefixData, ((WriteActivity) i.this.f63037a.getPageActivity()).mData.getFirstDir(), ((WriteActivity) i.this.f63037a.getPageActivity()).mData.getSecondDir());
            }
            albumFloatActivityConfig.setFromWrite(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }

        @Override // d.a.n0.w3.u.h.f
        public void c(int i2) {
            int count;
            ImageFileInfo imageInfoAt;
            if (i.this.f63039c == null || (count = ListUtils.getCount(i.this.f63039c.getChosedFiles())) == 0 || i2 < 0 || i2 >= count || (imageInfoAt = i.this.f63039c.getImageInfoAt(i2)) == null || imageInfoAt.getImageType() == 1) {
                return;
            }
            i.this.f63037a.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(i.this.f63037a.getPageActivity(), 12012, i.this.f63039c, i2)));
        }
    }

    public i(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.f63037a = tbPageContext;
        this.f63038b = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        h hVar = new h(view.getContext(), this.f63041e, null, this.f63044h);
        this.f63040d = hVar;
        this.f63038b.setAdapter((ListAdapter) hVar);
    }

    public void e() {
        this.f63041e.b();
    }

    public GridView f() {
        return this.f63038b;
    }

    public void g(boolean z) {
        this.f63040d.g(z);
    }

    public void h(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.f63042f = str;
        this.f63043g = str2;
        this.f63039c = writeImagesInfo;
        this.f63040d.f(writeImagesInfo);
        this.f63040d.notifyDataSetChanged();
    }
}
