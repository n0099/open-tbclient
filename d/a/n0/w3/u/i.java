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
import com.kwai.video.player.PlayerPostEvent;
import d.a.n0.w3.u.h;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<WriteActivity> f66752a;

    /* renamed from: b  reason: collision with root package name */
    public WriteImageGridView f66753b;

    /* renamed from: c  reason: collision with root package name */
    public WriteImagesInfo f66754c;

    /* renamed from: d  reason: collision with root package name */
    public h f66755d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.b0.b f66756e = new d.a.m0.b0.b();

    /* renamed from: f  reason: collision with root package name */
    public String f66757f = AlbumActivityConfig.FROM_WRITE;

    /* renamed from: g  reason: collision with root package name */
    public String f66758g = "";

    /* renamed from: h  reason: collision with root package name */
    public h.f f66759h = new a();

    /* loaded from: classes5.dex */
    public class a implements h.f {
        public a() {
        }

        @Override // d.a.n0.w3.u.h.f
        public void a(int i2) {
            if (i.this.f66754c == null || i.this.f66754c.getChosedFiles() == null || i2 < 0 || i2 >= i.this.f66754c.getChosedFiles().size()) {
                return;
            }
            ImageFileInfo remove = i.this.f66754c.getChosedFiles().remove(i2);
            if (remove.isTempFile()) {
                d.a.c.e.a.d.g().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
            }
            i iVar = i.this;
            iVar.f66755d.f(iVar.f66754c);
            i.this.f66755d.notifyDataSetChanged();
            if (ListUtils.isEmpty(i.this.f66754c.getChosedFiles()) && i.this.f66752a.getOrignalPage() != null) {
                ((WriteActivity) i.this.f66752a.getOrignalPage()).refreshPostButton();
            }
            if (i.this.f66752a.getPageActivity() instanceof WriteActivity) {
                ((WriteActivity) i.this.f66752a.getPageActivity()).refreshImageLauncher();
            }
        }

        @Override // d.a.n0.w3.u.h.f
        public void b() {
            if (i.this.f66754c == null) {
                return;
            }
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(i.this.f66752a.getPageActivity(), i.this.f66754c.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", i.this.f66758g);
            albumFloatActivityConfig.getIntent().putExtra("from", i.this.f66757f);
            albumFloatActivityConfig.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
            if (i.this.f66752a.getPageActivity() instanceof WriteActivity) {
                albumFloatActivityConfig.setCanSelectVideo(((WriteActivity) i.this.f66752a.getPageActivity()).canSelectVideo());
                AntiData antiData = new AntiData();
                antiData.voice_message = ((WriteActivity) i.this.f66752a.getPageActivity()).mDisableAudioMessage;
                antiData.setIfVoice(((WriteActivity) i.this.f66752a.getPageActivity()).isVoiceEnable);
                albumFloatActivityConfig.setStatisticFrom(((WriteActivity) i.this.f66752a.getPageActivity()).mData.getStatisticFrom());
                albumFloatActivityConfig.setExtraData(antiData, ((WriteActivity) i.this.f66752a.getPageActivity()).mPrefixData, ((WriteActivity) i.this.f66752a.getPageActivity()).mData.getFirstDir(), ((WriteActivity) i.this.f66752a.getPageActivity()).mData.getSecondDir());
            }
            albumFloatActivityConfig.setFromWrite(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }

        @Override // d.a.n0.w3.u.h.f
        public void c(int i2) {
            int count;
            ImageFileInfo imageInfoAt;
            if (i.this.f66754c == null || (count = ListUtils.getCount(i.this.f66754c.getChosedFiles())) == 0 || i2 < 0 || i2 >= count || (imageInfoAt = i.this.f66754c.getImageInfoAt(i2)) == null || imageInfoAt.getImageType() == 1) {
                return;
            }
            i.this.f66752a.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(i.this.f66752a.getPageActivity(), 12012, i.this.f66754c, i2)));
        }
    }

    public i(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.f66752a = tbPageContext;
        this.f66753b = (WriteImageGridView) view.findViewById(R.id.write_image_grid_view);
        h hVar = new h(view.getContext(), this.f66756e, null, this.f66759h);
        this.f66755d = hVar;
        this.f66753b.setAdapter((ListAdapter) hVar);
    }

    public void e() {
        this.f66756e.b();
    }

    public GridView f() {
        return this.f66753b;
    }

    public void g(boolean z) {
        this.f66755d.g(z);
    }

    public void h(WriteImagesInfo writeImagesInfo, String str, String str2) {
        this.f66757f = str;
        this.f66758g = str2;
        this.f66754c = writeImagesInfo;
        this.f66755d.f(writeImagesInfo);
        this.f66755d.notifyDataSetChanged();
    }
}
