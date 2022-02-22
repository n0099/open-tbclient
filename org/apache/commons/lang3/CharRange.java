package org.apache.commons.lang3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes5.dex */
public final class CharRange implements Iterable<Character>, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 8270183163158333422L;
    public transient /* synthetic */ FieldHolder $fh;
    public final char end;
    public transient String iToString;
    public final boolean negated;
    public final char start;

    /* renamed from: org.apache.commons.lang3.CharRange$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class CharacterIterator implements Iterator<Character> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public char current;
        public boolean hasNext;
        public final CharRange range;

        public /* synthetic */ CharacterIterator(CharRange charRange, AnonymousClass1 anonymousClass1) {
            this(charRange);
        }

        private void prepareNext() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                if (!this.range.negated) {
                    if (this.current < this.range.end) {
                        this.current = (char) (this.current + 1);
                        return;
                    } else {
                        this.hasNext = false;
                        return;
                    }
                }
                char c2 = this.current;
                if (c2 != 65535) {
                    if (c2 + 1 == this.range.start) {
                        if (this.range.end != 65535) {
                            this.current = (char) (this.range.end + 1);
                            return;
                        } else {
                            this.hasNext = false;
                            return;
                        }
                    }
                    this.current = (char) (this.current + 1);
                    return;
                }
                this.hasNext = false;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.hasNext : invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                throw new UnsupportedOperationException();
            }
        }

        public CharacterIterator(CharRange charRange) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {charRange};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.range = charRange;
            this.hasNext = true;
            if (charRange.negated) {
                if (this.range.start == 0) {
                    if (this.range.end != 65535) {
                        this.current = (char) (this.range.end + 1);
                        return;
                    } else {
                        this.hasNext = false;
                        return;
                    }
                }
                this.current = (char) 0;
                return;
            }
            this.current = this.range.start;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Character next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.hasNext) {
                    char c2 = this.current;
                    prepareNext();
                    return Character.valueOf(c2);
                }
                throw new NoSuchElementException();
            }
            return (Character) invokeV.objValue;
        }
    }

    public CharRange(char c2, char c3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Character.valueOf(c2), Character.valueOf(c3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (c2 > c3) {
            c3 = c2;
            c2 = c3;
        }
        this.start = c2;
        this.end = c3;
        this.negated = z;
    }

    public static CharRange is(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Character.valueOf(c2)})) == null) ? new CharRange(c2, c2, false) : (CharRange) invokeCommon.objValue;
    }

    public static CharRange isIn(char c2, char c3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Character.valueOf(c2), Character.valueOf(c3)})) == null) ? new CharRange(c2, c3, false) : (CharRange) invokeCommon.objValue;
    }

    public static CharRange isNot(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Character.valueOf(c2)})) == null) ? new CharRange(c2, c2, true) : (CharRange) invokeCommon.objValue;
    }

    public static CharRange isNotIn(char c2, char c3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Character.valueOf(c2), Character.valueOf(c3)})) == null) ? new CharRange(c2, c3, true) : (CharRange) invokeCommon.objValue;
    }

    public boolean contains(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Character.valueOf(c2)})) == null) {
            return (c2 >= this.start && c2 <= this.end) != this.negated;
        }
        return invokeCommon.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof CharRange) {
                CharRange charRange = (CharRange) obj;
                return this.start == charRange.start && this.end == charRange.end && this.negated == charRange.negated;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public char getEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.end : invokeV.charValue;
    }

    public char getStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.start : invokeV.charValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.start + 'S' + (this.end * 7) + (this.negated ? 1 : 0);
        }
        return invokeV.intValue;
    }

    public boolean isNegated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.negated : invokeV.booleanValue;
    }

    @Override // java.lang.Iterable
    public Iterator<Character> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new CharacterIterator(this, null) : (Iterator) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.iToString == null) {
                StringBuilder sb = new StringBuilder(4);
                if (isNegated()) {
                    sb.append('^');
                }
                sb.append(this.start);
                if (this.start != this.end) {
                    sb.append(SignatureImpl.SEP);
                    sb.append(this.end);
                }
                this.iToString = sb.toString();
            }
            return this.iToString;
        }
        return (String) invokeV.objValue;
    }

    public boolean contains(CharRange charRange) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charRange)) == null) {
            if (charRange != null) {
                return this.negated ? charRange.negated ? this.start >= charRange.start && this.end <= charRange.end : charRange.end < this.start || charRange.start > this.end : charRange.negated ? this.start == 0 && this.end == 65535 : this.start <= charRange.start && this.end >= charRange.end;
            }
            throw new IllegalArgumentException("The Range must not be null");
        }
        return invokeL.booleanValue;
    }
}
