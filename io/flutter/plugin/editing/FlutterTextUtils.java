package io.flutter.plugin.editing;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.FlutterJNI;
/* loaded from: classes4.dex */
public class FlutterTextUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CANCEL_TAG = 917631;
    public static final int CARRIAGE_RETURN = 13;
    public static final int COMBINING_ENCLOSING_KEYCAP = 8419;
    public static final int LINE_FEED = 10;
    public static final int ZERO_WIDTH_JOINER = 8205;
    public transient /* synthetic */ FieldHolder $fh;
    public final FlutterJNI flutterJNI;

    public FlutterTextUtils(FlutterJNI flutterJNI) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flutterJNI};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.flutterJNI = flutterJNI;
    }

    public int getOffsetAfter(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        int charCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, charSequence, i2)) == null) {
            int length = charSequence.length();
            int i3 = length - 1;
            if (i2 >= i3) {
                return length;
            }
            int codePointAt = Character.codePointAt(charSequence, i2);
            int charCount2 = Character.charCount(codePointAt);
            int i4 = i2 + charCount2;
            int i5 = 0;
            if (i4 == 0) {
                return 0;
            }
            if (codePointAt == 10) {
                if (Character.codePointAt(charSequence, i4) == 13) {
                    charCount2++;
                }
                return i2 + charCount2;
            } else if (isRegionalIndicatorSymbol(codePointAt)) {
                if (i4 >= i3 || !isRegionalIndicatorSymbol(Character.codePointAt(charSequence, i4))) {
                    return i4;
                }
                int i6 = i2;
                while (i6 > 0 && isRegionalIndicatorSymbol(Character.codePointBefore(charSequence, i2))) {
                    i6 -= Character.charCount(Character.codePointBefore(charSequence, i2));
                    i5++;
                }
                if (i5 % 2 == 0) {
                    charCount2 += 2;
                }
                return i2 + charCount2;
            } else {
                if (isKeycapBase(codePointAt)) {
                    charCount2 += Character.charCount(codePointAt);
                }
                if (codePointAt == 8419) {
                    int codePointBefore = Character.codePointBefore(charSequence, i4);
                    int charCount3 = i4 + Character.charCount(codePointBefore);
                    if (charCount3 < length && isVariationSelector(codePointBefore)) {
                        int codePointAt2 = Character.codePointAt(charSequence, charCount3);
                        if (isKeycapBase(codePointAt2)) {
                            charCount2 += Character.charCount(codePointBefore) + Character.charCount(codePointAt2);
                        }
                    } else if (isKeycapBase(codePointBefore)) {
                        charCount2 += Character.charCount(codePointBefore);
                    }
                    return i2 + charCount2;
                }
                if (isEmoji(codePointAt)) {
                    boolean z = false;
                    int i7 = 0;
                    do {
                        if (z) {
                            charCount2 += Character.charCount(codePointAt) + i7 + 1;
                            z = false;
                        }
                        if (isEmojiModifier(codePointAt)) {
                            break;
                        }
                        if (i4 < length) {
                            codePointAt = Character.codePointAt(charSequence, i4);
                            i4 += Character.charCount(codePointAt);
                            if (codePointAt == 8419) {
                                int codePointBefore2 = Character.codePointBefore(charSequence, i4);
                                int charCount4 = i4 + Character.charCount(codePointBefore2);
                                if (charCount4 < length && isVariationSelector(codePointBefore2)) {
                                    int codePointAt3 = Character.codePointAt(charSequence, charCount4);
                                    if (isKeycapBase(codePointAt3)) {
                                        charCount2 += Character.charCount(codePointBefore2) + Character.charCount(codePointAt3);
                                    }
                                } else if (isKeycapBase(codePointBefore2)) {
                                    charCount2 += Character.charCount(codePointBefore2);
                                }
                                return i2 + charCount2;
                            }
                            if (isEmojiModifier(codePointAt)) {
                                charCount = Character.charCount(codePointAt);
                            } else if (!isVariationSelector(codePointAt)) {
                                if (codePointAt == 8205) {
                                    codePointAt = Character.codePointAt(charSequence, i4);
                                    i4 += Character.charCount(codePointAt);
                                    if (i4 < length && isVariationSelector(codePointAt)) {
                                        codePointAt = Character.codePointAt(charSequence, i4);
                                        int charCount5 = Character.charCount(codePointAt);
                                        i4 += Character.charCount(codePointAt);
                                        i7 = charCount5;
                                        z = true;
                                        if (i4 < length || !z) {
                                            break;
                                            break;
                                        }
                                    } else {
                                        z = true;
                                    }
                                }
                            } else {
                                charCount = Character.charCount(codePointAt);
                            }
                            charCount2 += charCount + 0;
                            break;
                        }
                        i7 = 0;
                        if (i4 < length) {
                            break;
                        }
                    } while (isEmoji(codePointAt));
                }
                return i2 + charCount2;
            }
        }
        return invokeLI.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0158 A[EDGE_INSN: B:108:0x0158->B:97:0x0158 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getOffsetBefore(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        int codePointBefore;
        int charCount;
        int charCount2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2)) == null) {
            int i3 = 0;
            int i4 = 1;
            if (i2 > 1 && (charCount2 = i2 - (charCount = Character.charCount((codePointBefore = Character.codePointBefore(charSequence, i2))))) != 0) {
                if (codePointBefore == 10) {
                    if (Character.codePointBefore(charSequence, charCount2) == 13) {
                        charCount++;
                    }
                    return i2 - charCount;
                } else if (isRegionalIndicatorSymbol(codePointBefore)) {
                    int codePointBefore2 = Character.codePointBefore(charSequence, charCount2);
                    int charCount3 = charCount2 - Character.charCount(codePointBefore2);
                    while (charCount3 > 0 && isRegionalIndicatorSymbol(codePointBefore2)) {
                        codePointBefore2 = Character.codePointBefore(charSequence, charCount3);
                        charCount3 -= Character.charCount(codePointBefore2);
                        i4++;
                    }
                    if (i4 % 2 == 0) {
                        charCount += 2;
                    }
                    return i2 - charCount;
                } else if (codePointBefore == 8419) {
                    int codePointBefore3 = Character.codePointBefore(charSequence, charCount2);
                    int charCount4 = charCount2 - Character.charCount(codePointBefore3);
                    if (charCount4 > 0 && isVariationSelector(codePointBefore3)) {
                        int codePointBefore4 = Character.codePointBefore(charSequence, charCount4);
                        if (isKeycapBase(codePointBefore4)) {
                            charCount += Character.charCount(codePointBefore3) + Character.charCount(codePointBefore4);
                        }
                    } else if (isKeycapBase(codePointBefore3)) {
                        charCount += Character.charCount(codePointBefore3);
                    }
                    return i2 - charCount;
                } else {
                    if (codePointBefore == 917631) {
                        codePointBefore = Character.codePointBefore(charSequence, charCount2);
                        int charCount5 = Character.charCount(codePointBefore);
                        while (true) {
                            charCount2 -= charCount5;
                            if (charCount2 <= 0 || !isTagSpecChar(codePointBefore)) {
                                break;
                            }
                            charCount += Character.charCount(codePointBefore);
                            codePointBefore = Character.codePointBefore(charSequence, charCount2);
                            charCount5 = Character.charCount(codePointBefore);
                        }
                        if (!isEmoji(codePointBefore)) {
                            return i2 - 2;
                        }
                        charCount += Character.charCount(codePointBefore);
                    }
                    if (isVariationSelector(codePointBefore)) {
                        codePointBefore = Character.codePointBefore(charSequence, charCount2);
                        if (!isEmoji(codePointBefore)) {
                            return i2 - charCount;
                        }
                        charCount += Character.charCount(codePointBefore);
                        charCount2 -= charCount;
                    }
                    if (isEmoji(codePointBefore)) {
                        boolean z = false;
                        int i5 = 0;
                        while (true) {
                            if (z) {
                                charCount += Character.charCount(codePointBefore) + i5 + 1;
                                z = false;
                            }
                            if (isEmojiModifier(codePointBefore)) {
                                int codePointBefore5 = Character.codePointBefore(charSequence, charCount2);
                                int charCount6 = charCount2 - Character.charCount(codePointBefore5);
                                if (charCount6 > 0 && isVariationSelector(codePointBefore5)) {
                                    codePointBefore5 = Character.codePointBefore(charSequence, charCount6);
                                    if (!isEmoji(codePointBefore5)) {
                                        return i2 - charCount;
                                    }
                                    i3 = Character.charCount(codePointBefore5);
                                    Character.charCount(codePointBefore5);
                                }
                                if (isEmojiModifierBase(codePointBefore5)) {
                                    charCount += i3 + Character.charCount(codePointBefore5);
                                }
                            } else {
                                if (charCount2 > 0) {
                                    codePointBefore = Character.codePointBefore(charSequence, charCount2);
                                    charCount2 -= Character.charCount(codePointBefore);
                                    if (codePointBefore == 8205) {
                                        codePointBefore = Character.codePointBefore(charSequence, charCount2);
                                        charCount2 -= Character.charCount(codePointBefore);
                                        if (charCount2 > 0 && isVariationSelector(codePointBefore)) {
                                            codePointBefore = Character.codePointBefore(charSequence, charCount2);
                                            int charCount7 = Character.charCount(codePointBefore);
                                            charCount2 -= Character.charCount(codePointBefore);
                                            i5 = charCount7;
                                            z = true;
                                            if (charCount2 == 0) {
                                                break;
                                            } else if (!z) {
                                                break;
                                            } else if (isEmoji(codePointBefore)) {
                                                break;
                                            }
                                        } else {
                                            z = true;
                                        }
                                    }
                                }
                                i5 = 0;
                                if (charCount2 == 0) {
                                }
                            }
                        }
                    }
                    return i2 - charCount;
                }
            }
            return 0;
        }
        return invokeLI.intValue;
    }

    public boolean isEmoji(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.flutterJNI.nativeFlutterTextUtilsIsEmoji(i2) : invokeI.booleanValue;
    }

    public boolean isEmojiModifier(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.flutterJNI.nativeFlutterTextUtilsIsEmojiModifier(i2) : invokeI.booleanValue;
    }

    public boolean isEmojiModifierBase(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.flutterJNI.nativeFlutterTextUtilsIsEmojiModifierBase(i2) : invokeI.booleanValue;
    }

    public boolean isKeycapBase(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? (48 <= i2 && i2 <= 57) || i2 == 35 || i2 == 42 : invokeI.booleanValue;
    }

    public boolean isRegionalIndicatorSymbol(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? this.flutterJNI.nativeFlutterTextUtilsIsRegionalIndicator(i2) : invokeI.booleanValue;
    }

    public boolean isTagSpecChar(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? 917536 <= i2 && i2 <= 917630 : invokeI.booleanValue;
    }

    public boolean isVariationSelector(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? this.flutterJNI.nativeFlutterTextUtilsIsVariationSelector(i2) : invokeI.booleanValue;
    }
}
