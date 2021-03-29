package d.b.i0.u3.v;

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
import com.kwai.video.player.PlayerPostEvent;
import d.b.i0.u3.v.h;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<WriteActivity> f61800a;

    /* renamed from: b  reason: collision with root package name */
    public WriteImageGridView f61801b;

    /* renamed from: c  reason: collision with root package name */
    public WriteImagesInfo f61802c;

    /* renamed from: d  reason: collision with root package name */
    public h f61803d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.b0.b f61804e = new d.b.h0.b0.b();

    /* renamed from: f  reason: collision with root package name */
    public String f61805f = AlbumActivityConfig.FROM_WRITE;

    /* renamed from: g  reason: collision with root package name */
    public String f61806g = "";

    /* renamed from: h  reason: collision with root package name */
    public h.f f61807h = new a();

    /* loaded from: classes5.dex */
    public class a implements h.f {
        public a() {
        }

        @Override // d.b.i0.u3.v.h.f
        public void a(int i) {
            if (i.this.f61802c == null || i.this.f61802c.getChosedFiles() == null || i < 0 || i >= i.this.f61802c.getChosedFiles().size()) {
                return;
            }
            ImageFileInfo remove = i.this.f61802c.getChosedFiles().remove(i);
            if (remove.isTempFile()) {
                d.b.b.e.a.d.g().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            i iVar = i.this;
            iVar.f61803d.f(iVar.f61802c);
            i.this.f61803d.notifyDataSetChanged();
            if (ListUtils.isEmpty(i.this.f61802c.getChosedFiles()) && i.this.f61800a.getOrignalPage() != null) {
                ((WriteActivity) i.this.f61800a.getOrignalPage()).refreshPostButton();
            }
            if (i.this.f61800a.getPageActivity() instanceof WriteActivity) {
                ((WriteActivity) i.this.f61800a.getPageActivity()).refreshImageLauncher();
            }
        }

        @Override // d.b.i0.u3.v.h.f
        public void b(int i) {
            int count;
            ImageFileInfo imageInfoAt;
            if (i.this.f61802c == null || (count = ListUtils.getCount(i.this.f61802c.getChosedFiles())) == 0 || i < 0 || i >= count || (imageInfoAt = i.this.f61802c.getImageInfoAt(i)) == null || imageInfoAt.getImageType() == 1) {
                return;
            }
            i.this.f61800a.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(i.this.f61800a.getPageActivity(), 12012, i.this.f61802c, i)));
        }

        @Override // d.b.i0.u3.v.h.f
        public void c() {
            if (i.this.f61802c == null) {
                return;
            }
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(i.this.f61800a.getPageActivity(), i.this.f61802c.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", i.this.f61806g);
            albumFloatActivityConfig.getIntent().putExtra("from", i.this.f61805f);
            albumFloatActivityConfig.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
            if (i.this.f61800a.getPageActivity() instanceof WriteActivity) {
                albumFloatActivityConfig.setCanSelectVideo(((WriteActivity) i.this.f61800a.getPageActivity()).canSelectVideo());
                AntiData antiData = new AntiData();
                antiData.voice_message = ((WriteActivity) i.this.f61800a.getPageActivity()).mDisableAudioMessage;
                antiData.setIfVoice(((WriteActivity) i.this.f61800a.getPageActivity()).isVoiceEnable);
                albumFloatActivityConfig.setStatisticFrom(((WriteActivity) i.this.f61800a.getPageActivity()).mData.getStatisticFrom());
                albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) i.this.f61800a.getPageActivity()).mPrefixData, ((WriteActivity) i.this.f61800a.getPageActivity()).mData.getFirstDir(), ((WriteActivity) i.this.f61800a.getPageActivity()).mData.getSecondDir());
            }
            albumFloatActivityConfig.setFromWrite(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }
    }

    public i(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.f61800a = tbPageContext;
        this.f61801b = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        h hVar = new h(view.getContext(), this.f61804e, null, this.f61807h);
        this.f61803d = hVar;
        this.f61801b.setAdapter((ListAdapter) hVar);
    }

    public void e() {
        this.f61804e.b();
    }

    public GridView f() {
        return this.f61801b;
    }

    public void g(boolean z) {
        this.f61803d.g(z);
    }

    public void h(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.f61805f = str;
        this.f61806g = str2;
        this.f61802c = writeImagesInfo;
        this.f61803d.f(writeImagesInfo);
        this.f61803d.notifyDataSetChanged();
    }
}
