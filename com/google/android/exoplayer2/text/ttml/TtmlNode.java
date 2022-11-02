package com.google.android.exoplayer2.text.ttml;

import android.text.SpannableStringBuilder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
/* loaded from: classes7.dex */
public final class TtmlNode {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ANONYMOUS_REGION_ID = "";
    public static final String ATTR_ID = "id";
    public static final String ATTR_TTS_BACKGROUND_COLOR = "backgroundColor";
    public static final String ATTR_TTS_COLOR = "color";
    public static final String ATTR_TTS_DISPLAY_ALIGN = "displayAlign";
    public static final String ATTR_TTS_EXTENT = "extent";
    public static final String ATTR_TTS_FONT_FAMILY = "fontFamily";
    public static final String ATTR_TTS_FONT_SIZE = "fontSize";
    public static final String ATTR_TTS_FONT_STYLE = "fontStyle";
    public static final String ATTR_TTS_FONT_WEIGHT = "fontWeight";
    public static final String ATTR_TTS_ORIGIN = "origin";
    public static final String ATTR_TTS_TEXT_ALIGN = "textAlign";
    public static final String ATTR_TTS_TEXT_DECORATION = "textDecoration";
    public static final String BOLD = "bold";
    public static final String CENTER = "center";
    public static final String END = "end";
    public static final String ITALIC = "italic";
    public static final String LEFT = "left";
    public static final String LINETHROUGH = "linethrough";
    public static final String NO_LINETHROUGH = "nolinethrough";
    public static final String NO_UNDERLINE = "nounderline";
    public static final String RIGHT = "right";
    public static final String START = "start";
    public static final String TAG_BODY = "body";
    public static final String TAG_BR = "br";
    public static final String TAG_DIV = "div";
    public static final String TAG_HEAD = "head";
    public static final String TAG_LAYOUT = "layout";
    public static final String TAG_METADATA = "metadata";
    public static final String TAG_P = "p";
    public static final String TAG_REGION = "region";
    public static final String TAG_SMPTE_DATA = "smpte:data";
    public static final String TAG_SMPTE_IMAGE = "smpte:image";
    public static final String TAG_SMPTE_INFORMATION = "smpte:information";
    public static final String TAG_SPAN = "span";
    public static final String TAG_STYLE = "style";
    public static final String TAG_STYLING = "styling";
    public static final String TAG_TT = "tt";
    public static final String UNDERLINE = "underline";
    public transient /* synthetic */ FieldHolder $fh;
    public List<TtmlNode> children;
    public final long endTimeUs;
    public final boolean isTextNode;
    public final HashMap<String, Integer> nodeEndsByRegion;
    public final HashMap<String, Integer> nodeStartsByRegion;
    public final String regionId;
    public final long startTimeUs;
    public final TtmlStyle style;
    public final String[] styleIds;
    public final String tag;
    public final String text;

    public TtmlNode(String str, String str2, long j, long j2, TtmlStyle ttmlStyle, String[] strArr, String str3) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Long.valueOf(j), Long.valueOf(j2), ttmlStyle, strArr, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.tag = str;
        this.text = str2;
        this.style = ttmlStyle;
        this.styleIds = strArr;
        if (str2 != null) {
            z = true;
        } else {
            z = false;
        }
        this.isTextNode = z;
        this.startTimeUs = j;
        this.endTimeUs = j2;
        this.regionId = (String) Assertions.checkNotNull(str3);
        this.nodeStartsByRegion = new HashMap<>();
        this.nodeEndsByRegion = new HashMap<>();
    }

    private void applyStyleToOutput(Map<String, TtmlStyle> map, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        TtmlStyle resolveStyle;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLII(65537, this, map, spannableStringBuilder, i, i2) == null) && i != i2 && (resolveStyle = TtmlRenderUtil.resolveStyle(this.style, this.styleIds, map)) != null) {
            TtmlRenderUtil.applyStylesToSpan(spannableStringBuilder, i, i2, resolveStyle);
        }
    }

    public static TtmlNode buildNode(String str, long j, long j2, TtmlStyle ttmlStyle, String[] strArr, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), ttmlStyle, strArr, str2})) == null) {
            return new TtmlNode(str, null, j, j2, ttmlStyle, strArr, str2);
        }
        return (TtmlNode) invokeCommon.objValue;
    }

    public static TtmlNode buildTextNode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return new TtmlNode(null, TtmlRenderUtil.applyTextElementSpacePolicy(str), C.TIME_UNSET, C.TIME_UNSET, null, null, "");
        }
        return (TtmlNode) invokeL.objValue;
    }

    public void addChild(TtmlNode ttmlNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ttmlNode) == null) {
            if (this.children == null) {
                this.children = new ArrayList();
            }
            this.children.add(ttmlNode);
        }
    }

    public TtmlNode getChild(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            List<TtmlNode> list = this.children;
            if (list != null) {
                return list.get(i);
            }
            throw new IndexOutOfBoundsException();
        }
        return (TtmlNode) invokeI.objValue;
    }

    private SpannableStringBuilder cleanUpText(SpannableStringBuilder spannableStringBuilder) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, spannableStringBuilder)) == null) {
            int length = spannableStringBuilder.length();
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                if (spannableStringBuilder.charAt(i4) == ' ') {
                    int i5 = i4 + 1;
                    int i6 = i5;
                    while (i6 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i6) == ' ') {
                        i6++;
                    }
                    int i7 = i6 - i5;
                    if (i7 > 0) {
                        spannableStringBuilder.delete(i4, i4 + i7);
                        length -= i7;
                    }
                }
            }
            if (length > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
                length--;
            }
            int i8 = 0;
            while (true) {
                i = length - 1;
                if (i8 >= i) {
                    break;
                }
                if (spannableStringBuilder.charAt(i8) == '\n') {
                    int i9 = i8 + 1;
                    if (spannableStringBuilder.charAt(i9) == ' ') {
                        spannableStringBuilder.delete(i9, i8 + 2);
                        length--;
                    }
                }
                i8++;
            }
            if (length > 0 && spannableStringBuilder.charAt(i) == ' ') {
                spannableStringBuilder.delete(i, length);
                length--;
            }
            while (true) {
                i2 = length - 1;
                if (i3 >= i2) {
                    break;
                }
                if (spannableStringBuilder.charAt(i3) == ' ') {
                    int i10 = i3 + 1;
                    if (spannableStringBuilder.charAt(i10) == '\n') {
                        spannableStringBuilder.delete(i3, i10);
                        length--;
                    }
                }
                i3++;
            }
            if (length > 0 && spannableStringBuilder.charAt(i2) == '\n') {
                spannableStringBuilder.delete(i2, length);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    private void getEventTimes(TreeSet<Long> treeSet, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65541, this, treeSet, z) == null) {
            boolean equals = "p".equals(this.tag);
            if (z || equals) {
                long j = this.startTimeUs;
                if (j != C.TIME_UNSET) {
                    treeSet.add(Long.valueOf(j));
                }
                long j2 = this.endTimeUs;
                if (j2 != C.TIME_UNSET) {
                    treeSet.add(Long.valueOf(j2));
                }
            }
            if (this.children == null) {
                return;
            }
            for (int i = 0; i < this.children.size(); i++) {
                TtmlNode ttmlNode = this.children.get(i);
                if (!z && !equals) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                ttmlNode.getEventTimes(treeSet, z2);
            }
        }
    }

    public static SpannableStringBuilder getRegionOutput(String str, Map<String, SpannableStringBuilder> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, map)) == null) {
            if (!map.containsKey(str)) {
                map.put(str, new SpannableStringBuilder());
            }
            return map.get(str);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    private void traverseForStyle(Map<String, TtmlStyle> map, Map<String, SpannableStringBuilder> map2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, map, map2) == null) {
            for (Map.Entry<String, Integer> entry : this.nodeEndsByRegion.entrySet()) {
                String key = entry.getKey();
                if (this.nodeStartsByRegion.containsKey(key)) {
                    i = this.nodeStartsByRegion.get(key).intValue();
                } else {
                    i = 0;
                }
                applyStyleToOutput(map, map2.get(key), i, entry.getValue().intValue());
                for (int i2 = 0; i2 < getChildCount(); i2++) {
                    getChild(i2).traverseForStyle(map, map2);
                }
            }
        }
    }

    private void traverseForText(long j, boolean z, String str, Map<String, SpannableStringBuilder> map) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), str, map}) == null) {
            this.nodeStartsByRegion.clear();
            this.nodeEndsByRegion.clear();
            String str2 = this.regionId;
            if (!"".equals(str2)) {
                str = str2;
            }
            if (this.isTextNode && z) {
                getRegionOutput(str, map).append((CharSequence) this.text);
            } else if (TAG_BR.equals(this.tag) && z) {
                getRegionOutput(str, map).append('\n');
            } else if (!TAG_METADATA.equals(this.tag) && isActive(j)) {
                boolean equals = "p".equals(this.tag);
                for (Map.Entry<String, SpannableStringBuilder> entry : map.entrySet()) {
                    this.nodeStartsByRegion.put(entry.getKey(), Integer.valueOf(entry.getValue().length()));
                }
                for (int i = 0; i < getChildCount(); i++) {
                    TtmlNode child = getChild(i);
                    if (!z && !equals) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    child.traverseForText(j, z2, str, map);
                }
                if (equals) {
                    TtmlRenderUtil.endParagraph(getRegionOutput(str, map));
                }
                for (Map.Entry<String, SpannableStringBuilder> entry2 : map.entrySet()) {
                    this.nodeEndsByRegion.put(entry2.getKey(), Integer.valueOf(entry2.getValue().length()));
                }
            }
        }
    }

    public int getChildCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<TtmlNode> list = this.children;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public String[] getStyleIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.styleIds;
        }
        return (String[]) invokeV.objValue;
    }

    public List<Cue> getCues(long j, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), map, map2})) == null) {
            TreeMap treeMap = new TreeMap();
            traverseForText(j, false, this.regionId, treeMap);
            traverseForStyle(map, treeMap);
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : treeMap.entrySet()) {
                TtmlRegion ttmlRegion = map2.get(entry.getKey());
                arrayList.add(new Cue(cleanUpText((SpannableStringBuilder) entry.getValue()), null, ttmlRegion.line, ttmlRegion.lineType, ttmlRegion.lineAnchor, ttmlRegion.position, Integer.MIN_VALUE, ttmlRegion.width));
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public long[] getEventTimesUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TreeSet<Long> treeSet = new TreeSet<>();
            int i = 0;
            getEventTimes(treeSet, false);
            long[] jArr = new long[treeSet.size()];
            Iterator<Long> it = treeSet.iterator();
            while (it.hasNext()) {
                jArr[i] = it.next().longValue();
                i++;
            }
            return jArr;
        }
        return (long[]) invokeV.objValue;
    }

    public boolean isActive(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            if ((this.startTimeUs == C.TIME_UNSET && this.endTimeUs == C.TIME_UNSET) || ((this.startTimeUs <= j && this.endTimeUs == C.TIME_UNSET) || ((this.startTimeUs == C.TIME_UNSET && j < this.endTimeUs) || (this.startTimeUs <= j && j < this.endTimeUs)))) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }
}
