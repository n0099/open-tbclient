package com.google.android.exoplayer2.text.subrip;

import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public final class SubripDecoder extends SimpleSubtitleDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SUBRIP_TIMECODE = "(?:(\\d+):)?(\\d+):(\\d+),(\\d+)";
    public static final Pattern SUBRIP_TIMING_LINE;
    public static final String TAG = "SubripDecoder";
    public transient /* synthetic */ FieldHolder $fh;
    public final StringBuilder textBuilder;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1939839294, "Lcom/google/android/exoplayer2/text/subrip/SubripDecoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1939839294, "Lcom/google/android/exoplayer2/text/subrip/SubripDecoder;");
                return;
            }
        }
        SUBRIP_TIMING_LINE = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubripDecoder() {
        super(TAG);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.textBuilder = new StringBuilder();
    }

    public static long parseTimecode(Matcher matcher, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, matcher, i)) == null) ? ((Long.parseLong(matcher.group(i + 1)) * 60 * 60 * 1000) + (Long.parseLong(matcher.group(i + 2)) * 60 * 1000) + (Long.parseLong(matcher.group(i + 3)) * 1000) + Long.parseLong(matcher.group(i + 4))) * 1000 : invokeLI.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public SubripSubtitle decode(byte[] bArr, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            ArrayList arrayList = new ArrayList();
            LongArray longArray = new LongArray();
            ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i);
            while (true) {
                String readLine = parsableByteArray.readLine();
                if (readLine == null) {
                    break;
                } else if (readLine.length() != 0) {
                    try {
                        Integer.parseInt(readLine);
                        String readLine2 = parsableByteArray.readLine();
                        if (readLine2 == null) {
                            Log.w(TAG, "Unexpected end");
                            break;
                        }
                        Matcher matcher = SUBRIP_TIMING_LINE.matcher(readLine2);
                        if (matcher.matches()) {
                            boolean z2 = true;
                            longArray.add(parseTimecode(matcher, 1));
                            if (TextUtils.isEmpty(matcher.group(6))) {
                                z2 = false;
                            } else {
                                longArray.add(parseTimecode(matcher, 6));
                            }
                            this.textBuilder.setLength(0);
                            while (true) {
                                String readLine3 = parsableByteArray.readLine();
                                if (TextUtils.isEmpty(readLine3)) {
                                    break;
                                }
                                if (this.textBuilder.length() > 0) {
                                    this.textBuilder.append("<br>");
                                }
                                this.textBuilder.append(readLine3.trim());
                            }
                            arrayList.add(new Cue(Html.fromHtml(this.textBuilder.toString())));
                            if (z2) {
                                arrayList.add(null);
                            }
                        } else {
                            Log.w(TAG, "Skipping invalid timing: " + readLine2);
                        }
                    } catch (NumberFormatException unused) {
                        Log.w(TAG, "Skipping invalid index: " + readLine);
                    }
                }
            }
            Cue[] cueArr = new Cue[arrayList.size()];
            arrayList.toArray(cueArr);
            return new SubripSubtitle(cueArr, longArray.toArray());
        }
        return (SubripSubtitle) invokeCommon.objValue;
    }
}
