package d.b.j0.v3.v;

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
import d.b.j0.v3.v.h;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<WriteActivity> f63959a;

    /* renamed from: b  reason: collision with root package name */
    public WriteImageGridView f63960b;

    /* renamed from: c  reason: collision with root package name */
    public WriteImagesInfo f63961c;

    /* renamed from: d  reason: collision with root package name */
    public h f63962d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.b0.b f63963e = new d.b.i0.b0.b();

    /* renamed from: f  reason: collision with root package name */
    public String f63964f = AlbumActivityConfig.FROM_WRITE;

    /* renamed from: g  reason: collision with root package name */
    public String f63965g = "";

    /* renamed from: h  reason: collision with root package name */
    public h.f f63966h = new a();

    /* loaded from: classes5.dex */
    public class a implements h.f {
        public a() {
        }

        @Override // d.b.j0.v3.v.h.f
        public void a(int i) {
            if (i.this.f63961c == null || i.this.f63961c.getChosedFiles() == null || i < 0 || i >= i.this.f63961c.getChosedFiles().size()) {
                return;
            }
            ImageFileInfo remove = i.this.f63961c.getChosedFiles().remove(i);
            if (remove.isTempFile()) {
                d.b.c.e.a.d.g().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            i iVar = i.this;
            iVar.f63962d.f(iVar.f63961c);
            i.this.f63962d.notifyDataSetChanged();
            if (ListUtils.isEmpty(i.this.f63961c.getChosedFiles()) && i.this.f63959a.getOrignalPage() != null) {
                ((WriteActivity) i.this.f63959a.getOrignalPage()).refreshPostButton();
            }
            if (i.this.f63959a.getPageActivity() instanceof WriteActivity) {
                ((WriteActivity) i.this.f63959a.getPageActivity()).refreshImageLauncher();
            }
        }

        @Override // d.b.j0.v3.v.h.f
        public void b(int i) {
            int count;
            ImageFileInfo imageInfoAt;
            if (i.this.f63961c == null || (count = ListUtils.getCount(i.this.f63961c.getChosedFiles())) == 0 || i < 0 || i >= count || (imageInfoAt = i.this.f63961c.getImageInfoAt(i)) == null || imageInfoAt.getImageType() == 1) {
                return;
            }
            i.this.f63959a.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(i.this.f63959a.getPageActivity(), 12012, i.this.f63961c, i)));
        }

        @Override // d.b.j0.v3.v.h.f
        public void c() {
            if (i.this.f63961c == null) {
                return;
            }
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(i.this.f63959a.getPageActivity(), i.this.f63961c.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", i.this.f63965g);
            albumFloatActivityConfig.getIntent().putExtra("from", i.this.f63964f);
            albumFloatActivityConfig.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
            if (i.this.f63959a.getPageActivity() instanceof WriteActivity) {
                albumFloatActivityConfig.setCanSelectVideo(((WriteActivity) i.this.f63959a.getPageActivity()).canSelectVideo());
                AntiData antiData = new AntiData();
                antiData.voice_message = ((WriteActivity) i.this.f63959a.getPageActivity()).mDisableAudioMessage;
                antiData.setIfVoice(((WriteActivity) i.this.f63959a.getPageActivity()).isVoiceEnable);
                albumFloatActivityConfig.setStatisticFrom(((WriteActivity) i.this.f63959a.getPageActivity()).mData.getStatisticFrom());
                albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) i.this.f63959a.getPageActivity()).mPrefixData, ((WriteActivity) i.this.f63959a.getPageActivity()).mData.getFirstDir(), ((WriteActivity) i.this.f63959a.getPageActivity()).mData.getSecondDir());
            }
            albumFloatActivityConfig.setFromWrite(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }
    }

    public i(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.f63959a = tbPageContext;
        this.f63960b = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        h hVar = new h(view.getContext(), this.f63963e, null, this.f63966h);
        this.f63962d = hVar;
        this.f63960b.setAdapter((ListAdapter) hVar);
    }

    public void e() {
        this.f63963e.b();
    }

    public GridView f() {
        return this.f63960b;
    }

    public void g(boolean z) {
        this.f63962d.g(z);
    }

    public void h(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.f63964f = str;
        this.f63965g = str2;
        this.f63961c = writeImagesInfo;
        this.f63962d.f(writeImagesInfo);
        this.f63962d.notifyDataSetChanged();
    }
}
