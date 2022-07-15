package com.repackage;

import android.content.Intent;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.plugin.capture.bean.FaceItem;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WorkPublishActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.MediaScannerClient;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tieba.R;
import com.baidu.tieba.core.edit.TbMediaTrackConfig;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.TextWordsEntity;
import com.baidu.ugc.editvideo.data.VideoMuxerData;
import com.baidu.ugc.editvideo.muxer.VideoMuxer;
import com.baidu.ugc.editvideo.player.AudioPlayTrackData;
import com.baidu.ugc.editvideo.record.preview.GLMediaPreviewView;
import com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter;
import com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import com.baidu.ugc.utils.FileUtils;
import com.google.gson.Gson;
import com.repackage.c86;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes5.dex */
public class cu8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public final String b;
    public final d c;
    public TbMultiMediaData d;
    public t76 e;
    public VlogEditManager f;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ VideoInfo b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public a(TbPageContext tbPageContext, VideoInfo videoInfo, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, videoInfo, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
            this.b = videoInfo;
            this.c = str;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                z49.c().k(null);
                cu8.l(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements s76 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cu8 a;

        public b(cu8 cu8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cu8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cu8Var;
        }

        @Override // com.repackage.s76
        public void h0(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.c.h(str);
                this.a.d.coverPath = str;
                o45 o45Var = new o45();
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(str);
                ImageOperation g = x45.g(pi.k(this.a.a.getPageActivity()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2), pi.f(this.a.a.getPageActivity(), R.dimen.tbds866));
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(g);
                o45Var.d(imageFileInfo, null, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a59 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cu8 a;

        public c(cu8 cu8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cu8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cu8Var;
        }

        @Override // com.repackage.a59
        public IMediaPlayer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new cv8(this.a.a.getPageActivity()) : (IMediaPlayer) invokeV.objValue;
        }

        @Override // com.repackage.a59
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? yp8.c : (String) invokeV.objValue;
        }

        @Override // com.repackage.a59
        public h69 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (h69) invokeV.objValue;
        }

        @Override // com.repackage.a59
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "tieba_unknown" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class d implements d59 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.d59
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.repackage.d59
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.repackage.d59
        public final void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                g(str, this.a);
            }
        }

        @Override // com.repackage.d59
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        public abstract void g(String str, String str2);

        public void h(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.a = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755784597, "Lcom/repackage/cu8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755784597, "Lcom/repackage/cu8;");
        }
    }

    public cu8(@NonNull TbPageContext<?> tbPageContext, @NonNull String str, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = str;
        this.c = dVar;
        e();
        f();
    }

    public static void l(@NonNull TbPageContext<?> tbPageContext, @NonNull VideoInfo videoInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, null, tbPageContext, videoInfo, str, str2) == null) {
            Intent intent = new Intent();
            intent.putExtra("topic", str);
            intent.putExtra("topicId", str2);
            intent.putExtra("is_video_topic", "0");
            intent.putExtra(WorkPublishActivityConfig.VIDEO_MIXING, false);
            intent.putExtra(WorkPublishActivityConfig.NEED_PUBLISH_END_JUMP_HOME, true);
            WorkPublishOpenHelper.Companion.e(intent, videoInfo, tbPageContext.getPageActivity(), true, false);
        }
    }

    public static String m(TbPageContext<?> tbPageContext, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, tbPageContext, str)) == null) {
            File file = new File(str);
            File file2 = new File(yp8.g);
            if (!file2.exists()) {
                file2.mkdir();
            }
            String str2 = yp8.g + file.getName();
            if (!str2.equals(file.getAbsolutePath())) {
                FileHelper.copyFileByAbsolutelyPath(file.getAbsolutePath(), str2);
            }
            new MediaScannerClient(tbPageContext.getPageActivity()).saveVideo(str2);
            try {
                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent.setData(UtilHelper.getUriFromFile(file, intent, tbPageContext.getPageActivity()));
                tbPageContext.getPageActivity().sendBroadcast(intent);
            } catch (Exception e) {
                BdLog.d(e.getMessage());
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public static void n(@NonNull TbPageContext<?> tbPageContext, @NonNull String str, @NonNull String str2, String str3, String str4) {
        VideoFileInfo c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65544, null, tbPageContext, str, str2, str3, str4) == null) || (c2 = np8.c(str)) == null) {
            return;
        }
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(str);
        videoInfo.setVideoDuration((int) (c2.videoDuration / 1000.0f));
        videoInfo.setVideoWidth(c2.videoWidth);
        videoInfo.setVideoHeight(c2.videoHeight);
        videoInfo.setVideoLength(new File(str).length());
        videoInfo.setVideoSource(2);
        videoInfo.setIsCompressedVideo(true);
        videoInfo.setThumbPath(str2);
        EditVideoData editVideoData = new EditVideoData();
        if (StringUtils.isNull(videoInfo.getThumbPath())) {
            editVideoData.coverPath = yp8.b;
        } else {
            editVideoData.coverPath = videoInfo.getThumbPath();
        }
        editVideoData.originPath = videoInfo.getVideoPath();
        videoInfo.setEditVideoData(editVideoData);
        videoInfo.setMultiMediaData(jv8.a(videoInfo));
        qg.a().post(new a(tbPageContext, videoInfo, str3, str4));
    }

    public static VideoMuxer p(@NonNull TbPageContext<?> tbPageContext, @NonNull String str, @NonNull List<fu8> list, @NonNull d dVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65545, null, tbPageContext, str, list, dVar)) == null) ? new cu8(tbPageContext, str, dVar).o(list) : (VideoMuxer) invokeLLLL.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            VideoFileInfo c2 = np8.c(this.b);
            if (c2 == null) {
                this.a.getPageActivity().finish();
                return;
            }
            TbMultiMediaData tbMultiMediaData = new TbMultiMediaData();
            this.d = tbMultiMediaData;
            tbMultiMediaData.path = c2.videoPath;
            tbMultiMediaData.coverPath = c2.thumbPath;
            int i = c2.videoHeight;
            tbMultiMediaData.height = i;
            int i2 = c2.videoWidth;
            tbMultiMediaData.width = i2;
            tbMultiMediaData.type = 1;
            tbMultiMediaData.start = 0L;
            int i3 = c2.videoDuration;
            tbMultiMediaData.end = i3;
            tbMultiMediaData.originalDuration = i3;
            tbMultiMediaData.scaleType = "center_inside";
            tbMultiMediaData.videoInfoSource = 2;
            tbMultiMediaData.coverSource = 1;
            tbMultiMediaData.videoRatio = (i * 1.0f) / i2;
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!mp8.a()) {
                this.a.getPageActivity().finish();
                return;
            }
            g();
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = new MultiMediaDataSourceViewAdapter();
            this.f = new VlogEditManager(multiMediaDataSourceViewAdapter);
            GLMediaPreviewView gLMediaPreviewView = new GLMediaPreviewView(TbadkCoreApplication.getInst());
            gLMediaPreviewView.setZOrderMediaOverlay(true);
            gLMediaPreviewView.setMultiMediaDataSourceViewAdapter(multiMediaDataSourceViewAdapter, false);
            gLMediaPreviewView.setCanMeasure(false);
            gLMediaPreviewView.setVideoRatio(this.d.videoRatio);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.d);
            this.f.setMultiMediaData(arrayList);
            this.f.setVideoRatio(this.d.videoRatio);
            this.e = new t76(true);
            h();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            z49.c().h(TbadkCoreApplication.getInst());
            z49.c().j(FileHelper.getCacheDir());
            z49.c().k(new c(this));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c86.a aVar = new c86.a();
            aVar.t(this.d.width);
            aVar.o(this.d.height);
            aVar.p(true);
            aVar.r(this.d.videoRatio);
            VlogEditManager vlogEditManager = this.f;
            aVar.q(vlogEditManager == null ? null : vlogEditManager.getMultiMediaData(vlogEditManager.getCurrentIndex()));
            aVar.s("manual");
            c86 m = aVar.m();
            this.e.e(new b(this));
            this.e.d(false);
            this.e.b(m, "default");
        }
    }

    public final void i(String str, long j, long j2, double d2, double d3, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Double.valueOf(d2), Double.valueOf(d3), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            MultiMediaData multiMediaData = new MultiMediaData();
            Bitmap image = FileHelper.getImage(str);
            if (image != null) {
                multiMediaData.path = str;
                multiMediaData.width = i;
                multiMediaData.height = i2;
                multiMediaData.scaleType = "adaptive";
                multiMediaData.type = 0;
                multiMediaData.start = j;
                multiMediaData.end = j2;
                multiMediaData.x = ((int) d2) - (i >> 1);
                multiMediaData.y = ((int) d3) - (i2 >> 1);
                image.recycle();
                this.f.seek(j);
                this.f.addStickerData(multiMediaData, FaceItem.DIR_STICKER);
            }
        }
    }

    public final void j(fu8 fu8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fu8Var) == null) {
            int i = fu8Var.b;
            if (i == 1) {
                k(fu8Var.a, fu8Var.e, fu8Var.f, fu8Var.g, fu8Var.h, fu8Var.i, fu8Var.j, fu8Var.k);
            } else if (i == 2) {
                i(fu8Var.a, fu8Var.e, fu8Var.f, fu8Var.g, fu8Var.h, fu8Var.c, fu8Var.d);
            }
        }
    }

    public final void k(String str, long j, long j2, double d2, double d3, double d4, double d5, String str2) {
        int f;
        int height;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), str2}) == null) {
            pp8.d().j((int) d5);
            String videoTmpDir = FileHelper.getVideoTmpDir();
            String str3 = System.currentTimeMillis() + ".jpg";
            TextWordsEntity.TextStyleEntity textStyleEntity = new TextWordsEntity.TextStyleEntity();
            textStyleEntity.mTextInfoList = new ArrayList();
            textStyleEntity.mStrokeInfoList = new ArrayList();
            TextWordsEntity.StyleTextInfoEntity styleTextInfoEntity = new TextWordsEntity.StyleTextInfoEntity();
            if (!sg8.e(sg8.f(str2)) && str2 != null && str2.startsWith("#") && str2.length() >= 7) {
                styleTextInfoEntity.mTextAlpha = String.format(Locale.CHINA, "%.1f", Double.valueOf(((f >>> 24) * 1.0d) / 255.0d));
                styleTextInfoEntity.mTextColor = str2.substring(str2.length() - 6, str2.length());
            } else {
                styleTextInfoEntity.mTextAlpha = "0.0";
                styleTextInfoEntity.mTextColor = "000000";
            }
            textStyleEntity.mTextInfoList.add(styleTextInfoEntity);
            Bitmap h = pp8.d().h(TbadkCoreApplication.getInst(), str, textStyleEntity, null);
            MultiMediaData multiMediaData = new MultiMediaData();
            FileUtils.saveBitmap2PNG(videoTmpDir, str3, h, 100);
            multiMediaData.path = videoTmpDir + File.separator + str3;
            multiMediaData.width = h.getWidth();
            multiMediaData.height = h.getHeight();
            multiMediaData.scaleType = "adaptive";
            multiMediaData.type = 0;
            multiMediaData.start = j;
            multiMediaData.end = j2;
            if (d4 == 1.0d) {
                multiMediaData.x = ((int) d2) - (multiMediaData.width >> 1);
                multiMediaData.y = ((int) d3) - (height >> 1);
            } else if (d4 == 2.0d) {
                pp8.d().getClass();
                multiMediaData.x = ((int) d2) - 20;
                multiMediaData.y = ((int) d3) - (multiMediaData.height >> 1);
            } else if (d4 == 3.0d) {
                int i = ((int) d2) - multiMediaData.width;
                pp8.d().getClass();
                multiMediaData.x = i + 20;
                multiMediaData.y = ((int) d3) - (multiMediaData.height >> 1);
            } else {
                multiMediaData.x = (int) d2;
                multiMediaData.y = (int) d3;
            }
            h.recycle();
            this.f.seek(j);
            this.f.addStickerData(multiMediaData, FaceItem.DIR_STICKER);
        }
    }

    public final VideoMuxer o(@NonNull List<fu8> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, list)) == null) {
            for (fu8 fu8Var : list) {
                j(fu8Var);
            }
            VideoMuxerData videoMuxerData = new VideoMuxerData();
            videoMuxerData.setCompat(true);
            videoMuxerData.setPhotoDataList(this.f.getInputMultiMediaData());
            videoMuxerData.setStickerDataList(this.f.getStickerMultiMediaDataList(false));
            videoMuxerData.setUserNewAudioMixture(true);
            ArrayList arrayList = new ArrayList();
            AudioPlayTrackData audioPlayTrackData = new AudioPlayTrackData();
            audioPlayTrackData.mAudioPlayDataList = new ArrayList();
            arrayList.add(audioPlayTrackData);
            videoMuxerData.setAudioPlayTrackDataList(arrayList);
            videoMuxerData.setPreviewWidth(this.f.getMultiMediaData(0).width);
            videoMuxerData.setPreviewHeight(this.f.getMultiMediaData(0).height);
            videoMuxerData.setOutWidth(this.f.getMultiMediaData(0).width);
            videoMuxerData.setOutHeight(this.f.getMultiMediaData(0).height);
            videoMuxerData.setOutBitRate(this.f.getMultiMediaData(0).width * this.f.getMultiMediaData(0).height * 6);
            videoMuxerData.setComposeNecessary(true);
            videoMuxerData.setCurrThemeEffect((MediaTrackConfig) new Gson().fromJson(this.f.exportConfigJson(MediaTrackConfig.AE_IMPORT_DRAFT), (Class<Object>) TbMediaTrackConfig.class));
            VideoMuxer videoMuxer = new VideoMuxer();
            videoMuxer.setListener(this.c);
            videoMuxer.startMuxer(videoMuxerData);
            return videoMuxer;
        }
        return (VideoMuxer) invokeL.objValue;
    }
}
