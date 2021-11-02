package org.apache.commons.lang3.text.translate;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes3.dex */
public class LookupTranslator extends CharSequenceTranslator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int longest;
    public final HashMap<String, String> lookupMap;
    public final HashSet<Character> prefixSet;
    public final int shortest;

    public LookupTranslator(CharSequence[]... charSequenceArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {charSequenceArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.lookupMap = new HashMap<>();
        this.prefixSet = new HashSet<>();
        int i4 = 0;
        int i5 = Integer.MAX_VALUE;
        if (charSequenceArr != null) {
            int i6 = 0;
            for (CharSequence[] charSequenceArr2 : charSequenceArr) {
                this.lookupMap.put(charSequenceArr2[0].toString(), charSequenceArr2[1].toString());
                this.prefixSet.add(Character.valueOf(charSequenceArr2[0].charAt(0)));
                int length = charSequenceArr2[0].length();
                i5 = length < i5 ? length : i5;
                if (length > i6) {
                    i6 = length;
                }
            }
            i4 = i6;
        }
        this.shortest = i5;
        this.longest = i4;
    }

    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i2, Writer writer) throws IOException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, charSequence, i2, writer)) == null) {
            if (this.prefixSet.contains(Character.valueOf(charSequence.charAt(i2)))) {
                int i3 = this.longest;
                if (i2 + i3 > charSequence.length()) {
                    i3 = charSequence.length() - i2;
                }
                while (i3 >= this.shortest) {
                    String str = this.lookupMap.get(charSequence.subSequence(i2, i2 + i3).toString());
                    if (str != null) {
                        writer.write(str);
                        return i3;
                    }
                    i3--;
                }
                return 0;
            }
            return 0;
        }
        return invokeLIL.intValue;
    }
}
