package d.b.i0.v3.v;

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
import d.b.i0.v3.v.h;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<WriteActivity> f63538a;

    /* renamed from: b  reason: collision with root package name */
    public WriteImageGridView f63539b;

    /* renamed from: c  reason: collision with root package name */
    public WriteImagesInfo f63540c;

    /* renamed from: d  reason: collision with root package name */
    public h f63541d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.b0.b f63542e = new d.b.h0.b0.b();

    /* renamed from: f  reason: collision with root package name */
    public String f63543f = AlbumActivityConfig.FROM_WRITE;

    /* renamed from: g  reason: collision with root package name */
    public String f63544g = "";

    /* renamed from: h  reason: collision with root package name */
    public h.f f63545h = new a();

    /* loaded from: classes5.dex */
    public class a implements h.f {
        public a() {
        }

        @Override // d.b.i0.v3.v.h.f
        public void a(int i) {
            if (i.this.f63540c == null || i.this.f63540c.getChosedFiles() == null || i < 0 || i >= i.this.f63540c.getChosedFiles().size()) {
                return;
            }
            ImageFileInfo remove = i.this.f63540c.getChosedFiles().remove(i);
            if (remove.isTempFile()) {
                d.b.c.e.a.d.g().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            i iVar = i.this;
            iVar.f63541d.f(iVar.f63540c);
            i.this.f63541d.notifyDataSetChanged();
            if (ListUtils.isEmpty(i.this.f63540c.getChosedFiles()) && i.this.f63538a.getOrignalPage() != null) {
                ((WriteActivity) i.this.f63538a.getOrignalPage()).refreshPostButton();
            }
            if (i.this.f63538a.getPageActivity() instanceof WriteActivity) {
                ((WriteActivity) i.this.f63538a.getPageActivity()).refreshImageLauncher();
            }
        }

        @Override // d.b.i0.v3.v.h.f
        public void b(int i) {
            int count;
            ImageFileInfo imageInfoAt;
            if (i.this.f63540c == null || (count = ListUtils.getCount(i.this.f63540c.getChosedFiles())) == 0 || i < 0 || i >= count || (imageInfoAt = i.this.f63540c.getImageInfoAt(i)) == null || imageInfoAt.getImageType() == 1) {
                return;
            }
            i.this.f63538a.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(i.this.f63538a.getPageActivity(), 12012, i.this.f63540c, i)));
        }

        @Override // d.b.i0.v3.v.h.f
        public void c() {
            if (i.this.f63540c == null) {
                return;
            }
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(i.this.f63538a.getPageActivity(), i.this.f63540c.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", i.this.f63544g);
            albumFloatActivityConfig.getIntent().putExtra("from", i.this.f63543f);
            albumFloatActivityConfig.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
            if (i.this.f63538a.getPageActivity() instanceof WriteActivity) {
                albumFloatActivityConfig.setCanSelectVideo(((WriteActivity) i.this.f63538a.getPageActivity()).canSelectVideo());
                AntiData antiData = new AntiData();
                antiData.voice_message = ((WriteActivity) i.this.f63538a.getPageActivity()).mDisableAudioMessage;
                antiData.setIfVoice(((WriteActivity) i.this.f63538a.getPageActivity()).isVoiceEnable);
                albumFloatActivityConfig.setStatisticFrom(((WriteActivity) i.this.f63538a.getPageActivity()).mData.getStatisticFrom());
                albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) i.this.f63538a.getPageActivity()).mPrefixData, ((WriteActivity) i.this.f63538a.getPageActivity()).mData.getFirstDir(), ((WriteActivity) i.this.f63538a.getPageActivity()).mData.getSecondDir());
            }
            albumFloatActivityConfig.setFromWrite(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }
    }

    public i(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.f63538a = tbPageContext;
        this.f63539b = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        h hVar = new h(view.getContext(), this.f63542e, null, this.f63545h);
        this.f63541d = hVar;
        this.f63539b.setAdapter((ListAdapter) hVar);
    }

    public void e() {
        this.f63542e.b();
    }

    public GridView f() {
        return this.f63539b;
    }

    public void g(boolean z) {
        this.f63541d.g(z);
    }

    public void h(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.f63543f = str;
        this.f63544g = str2;
        this.f63540c = writeImagesInfo;
        this.f63541d.f(writeImagesInfo);
        this.f63541d.notifyDataSetChanged();
    }
}
