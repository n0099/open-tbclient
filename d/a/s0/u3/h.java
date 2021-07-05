package d.a.s0.u3;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import com.baidu.ugc.editvideo.data.TextWordsEntity;
import com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager;
import com.baidu.ugc.utils.FileUtils;
import d.a.y0.t.t;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f67403a;

    /* renamed from: b  reason: collision with root package name */
    public VlogEditManager f67404b;

    /* renamed from: c  reason: collision with root package name */
    public int f67405c;

    /* renamed from: d  reason: collision with root package name */
    public int f67406d;

    /* renamed from: e  reason: collision with root package name */
    public TextWordsEntity.TextStyleEntity f67407e;

    /* renamed from: f  reason: collision with root package name */
    public TextWordsEntity.TextFontEntity f67408f;

    /* renamed from: g  reason: collision with root package name */
    public int f67409g;

    /* renamed from: h  reason: collision with root package name */
    public String f67410h;

    public h(Context context, VlogEditManager vlogEditManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, vlogEditManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67409g = -1;
        this.f67410h = "";
        this.f67403a = context;
        this.f67404b = vlogEditManager;
    }

    public void a(int i2, String str, MultiMediaData multiMediaData, TextWordsEntity.TextStyleEntity textStyleEntity, TextWordsEntity.TextFontEntity textFontEntity) {
        TextWordsEntity.TextStyleEntity textStyleEntity2;
        TextWordsEntity.TextFontEntity textFontEntity2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, multiMediaData, textStyleEntity, textFontEntity}) == null) || multiMediaData == null) {
            return;
        }
        if (108 == i2 && TextUtils.isEmpty(str)) {
            multiMediaData.setExt("text", t.l(R.string.ugc_capture_text_words_hint));
        }
        if (this.f67409g != -1 && !TextUtils.isEmpty(str)) {
            multiMediaData.setExt("text", str);
        }
        if (textStyleEntity != null) {
            multiMediaData.setExt(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_STYLE, TextWordsEntity.TextStyleEntity.toJson(textStyleEntity).toString());
        } else {
            try {
                String ext = multiMediaData.getExt(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_STYLE);
                if (!TextUtils.isEmpty(ext)) {
                    textStyleEntity2 = TextWordsEntity.TextStyleEntity.parse(new JSONObject(ext));
                } else {
                    textStyleEntity2 = this.f67407e;
                }
                textStyleEntity = textStyleEntity2;
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
        }
        if (textFontEntity != null) {
            multiMediaData.setExt(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_FONT, TextWordsEntity.TextFontEntity.toJson(textFontEntity).toString());
        } else {
            try {
                String ext2 = multiMediaData.getExt(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_FONT);
                if (!TextUtils.isEmpty(ext2)) {
                    textFontEntity2 = TextWordsEntity.TextFontEntity.parse(new JSONObject(ext2));
                } else {
                    textFontEntity2 = this.f67408f;
                }
                textFontEntity = textFontEntity2;
            } catch (JSONException e3) {
                BdLog.e(e3);
            }
        }
        String ext3 = multiMediaData.getExt(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_TEMP_PATH);
        String videoTmpDir = FileHelper.getVideoTmpDir();
        String str2 = System.currentTimeMillis() + ".jpg";
        Bitmap h2 = e.d().h(this.f67403a, multiMediaData.getExt("text"), textStyleEntity, textFontEntity);
        if (!TextUtils.isEmpty(multiMediaData.path) && !multiMediaData.path.equals(ext3)) {
            FileUtils.delete(new File(multiMediaData.path));
        }
        FileUtils.saveBitmap2PNG(videoTmpDir, str2, h2, 100);
        multiMediaData.path = videoTmpDir + File.separator + str2;
        int i3 = multiMediaData.width;
        int i4 = multiMediaData.height;
        multiMediaData.width = h2.getWidth();
        int height = h2.getHeight();
        multiMediaData.height = height;
        if (this.f67409g == -1) {
            multiMediaData.scaleType = "adaptive";
            multiMediaData.type = 0;
            multiMediaData.start = this.f67404b.getCurrentPlayTime();
            multiMediaData.end = this.f67404b.getCurrentPlayTime() + 3000;
            multiMediaData.x = (this.f67405c - multiMediaData.width) / 2.0f;
            multiMediaData.y = (this.f67406d - multiMediaData.height) / 2.0f;
            if (TextUtils.equals(this.f67410h, "cover_sticker")) {
                this.f67404b.addCoverStickerData(multiMediaData);
            } else {
                this.f67404b.addStickerData(multiMediaData, this.f67410h);
            }
        } else {
            float f2 = multiMediaData.x + (i3 / 2.0f);
            float f3 = multiMediaData.y + (i4 / 2.0f);
            multiMediaData.x = f2 - (multiMediaData.width / 2.0f);
            multiMediaData.y = f3 - (height / 2.0f);
            if (TextUtils.equals(this.f67410h, "cover_sticker")) {
                this.f67404b.replaceCoverStickerData(multiMediaData);
            } else {
                this.f67404b.replaceStickerData(this.f67409g, multiMediaData, this.f67410h);
            }
        }
        h2.recycle();
    }

    public void b(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, multiMediaData) == null) || multiMediaData == null || TextUtils.isEmpty(multiMediaData.path)) {
            return;
        }
        FileUtils.delete(new File(multiMediaData.path));
    }

    public boolean c(MultiMediaData multiMediaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, multiMediaData)) == null) {
            if (multiMediaData == null) {
                return false;
            }
            String ext = multiMediaData.getExt("text");
            if (TextUtils.isEmpty(ext)) {
                return false;
            }
            return ext.equals(t.l(R.string.ugc_capture_text_words_hint));
        }
        return invokeL.booleanValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f67409g = i2;
        }
    }

    public void e(TextWordsEntity.TextFontEntity textFontEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, textFontEntity) == null) {
            this.f67408f = textFontEntity;
        }
    }

    public void f(TextWordsEntity.TextStyleEntity textStyleEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, textStyleEntity) == null) {
            this.f67407e = textStyleEntity;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f67410h = str;
        }
    }

    public void h(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            this.f67405c = i2;
            this.f67406d = i3;
        }
    }
}
