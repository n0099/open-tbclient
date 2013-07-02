package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
/* loaded from: classes.dex */
public final class ConstructorConstructor {
    private final Map instanceCreators;

    public ConstructorConstructor(Map map) {
        this.instanceCreators = map;
    }

    public ConstructorConstructor() {
        this(Collections.emptyMap());
    }

    public ObjectConstructor get(TypeToken typeToken) {
        final Type type = typeToken.getType();
        Class rawType = typeToken.getRawType();
        final InstanceCreator instanceCreator = (InstanceCreator) this.instanceCreators.get(type);
        if (instanceCreator != null) {
            return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor.1
                @Override // com.google.gson.internal.ObjectConstructor
                public Object construct() {
                    return instanceCreator.createInstance(type);
                }
            };
        }
        ObjectConstructor newDefaultConstructor = newDefaultConstructor(rawType);
        if (newDefaultConstructor == null) {
            ObjectConstructor newDefaultImplementationConstructor = newDefaultImplementationConstructor(rawType);
            return newDefaultImplementationConstructor == null ? newUnsafeAllocator(type, rawType) : newDefaultImplementationConstructor;
        }
        return newDefaultConstructor;
    }

    private ObjectConstructor newDefaultConstructor(Class cls) {
        try {
            final Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor.2
                @Override // com.google.gson.internal.ObjectConstructor
                public Object construct() {
                    try {
                        return declaredConstructor.newInstance(null);
                    } catch (IllegalAccessException e) {
                        throw new AssertionError(e);
                    } catch (InstantiationException e2) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e2);
                    } catch (InvocationTargetException e3) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e3.getTargetException());
                    }
                }
            };
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private ObjectConstructor newDefaultImplementationConstructor(Class cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor.3
                    @Override // com.google.gson.internal.ObjectConstructor
                    public Object construct() {
                        return new TreeSet();
                    }
                };
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor.4
                    @Override // com.google.gson.internal.ObjectConstructor
                    public Object construct() {
                        return new LinkedHashSet();
                    }
                };
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor.5
                    @Override // com.google.gson.internal.ObjectConstructor
                    public Object construct() {
                        return new LinkedList();
                    }
                };
            }
            return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor.6
                @Override // com.google.gson.internal.ObjectConstructor
                public Object construct() {
                    return new ArrayList();
                }
            };
        } else if (Map.class.isAssignableFrom(cls)) {
            return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor.7
                @Override // com.google.gson.internal.ObjectConstructor
                public Object construct() {
                    return new LinkedHashMap();
                }
            };
        } else {
            return null;
        }
    }

    private ObjectConstructor newUnsafeAllocator(final Type type, final Class cls) {
        return new ObjectConstructor() { // from class: com.google.gson.internal.ConstructorConstructor.8
            private final UnsafeAllocator unsafeAllocator = UnsafeAllocator.create();

            @Override // com.google.gson.internal.ObjectConstructor
            public Object construct() {
                try {
                    return this.unsafeAllocator.newInstance(cls);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". Register an InstanceCreator with Gson for this type may fix this problem.", e);
                }
            }
        };
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
