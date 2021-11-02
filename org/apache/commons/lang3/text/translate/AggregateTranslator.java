package org.apache.commons.lang3.text.translate;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.Writer;
import org.apache.commons.lang3.ArrayUtils;
/* loaded from: classes3.dex */
public class AggregateTranslator extends CharSequenceTranslator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CharSequenceTranslator[] translators;

    public AggregateTranslator(CharSequenceTranslator... charSequenceTranslatorArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {charSequenceTranslatorArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.translators = (CharSequenceTranslator[]) ArrayUtils.clone(charSequenceTranslatorArr);
    }

    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i2, Writer writer) throws IOException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, charSequence, i2, writer)) == null) {
            for (CharSequenceTranslator charSequenceTranslator : this.translators) {
                int translate = charSequenceTranslator.translate(charSequence, i2, writer);
                if (translate != 0) {
                    return translate;
                }
            }
            return 0;
        }
        return invokeLIL.intValue;
    }
}
