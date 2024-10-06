# Taller4Oracle_springjpa

# Funciones y Procedimientos en PL/SQL

Este proyecto incluye varias funciones y un procedimiento almacenado en PL/SQL. A continuación se describen cada una de ellas.


## 1. Calcular Factorial

```sql
CREATE OR REPLACE FUNCTION calcular_factorial (num IN NUMBER) 
RETURN NUMBER 
IS
    resultado NUMBER := 1;
BEGIN
    FOR i IN 1..num LOOP
        resultado := resultado * i;
    END LOOP;
    RETURN resultado;
END;
/
```


## 2.  Calcular Máximo Común Divisor (MCD)

```sql
CREATE OR REPLACE FUNCTION calcular_mcd(num1 IN NUMBER, num2 IN NUMBER)
RETURN NUMBER
IS
    a NUMBER := num1;
    b NUMBER := num2;
    resultado NUMBER;
BEGIN
    WHILE b != 0 LOOP
        resultado := a MOD b;
        a := b;
        b := resultado;
    END LOOP;
    RETURN a;
END;
/

```


## 3.  Verificar si un Número es Primo

```sql
CREATE OR REPLACE FUNCTION es_primo(num IN NUMBER)
RETURN VARCHAR2
IS
    divisor NUMBER := 2;
BEGIN
    IF num <= 1 THEN
        RETURN 'El número no es primo';
    END IF;

    WHILE divisor <= SQRT(num) LOOP
        IF MOD(num, divisor) = 0 THEN
            RETURN 'El número no es primo';
        END IF;
        divisor := divisor + 1;
    END LOOP;

    RETURN 'El número es primo';
END;
/

```


## 4.  Calcular la Secuencia de Fibonacci

```sql
CREATE OR REPLACE FUNCTION fibonacci(num IN NUMBER)
RETURN VARCHAR2
IS
    a NUMBER := 0;
    b NUMBER := 1;
    c NUMBER;
    resultado VARCHAR2(4000) := '0';
BEGIN
    IF num <= 0 THEN
        RETURN 'El número debe ser mayor que 0';
    ELSIF num = 1 THEN
        RETURN '0';
    END IF;

    FOR i IN 2..num LOOP
        resultado := resultado || ', ' || b;
        c := a + b;
        a := b;
        b := c;
    END LOOP;

    RETURN resultado;
END;
/

```

## 5.  Procedimiento ,Actualizar el Precio de un Producto

```sql
CREATE OR REPLACE PROCEDURE actualizar_precio_producto(
    p_cod_producto IN CHAR,   
    p_nuevo_precio IN NUMBER 
)
AS
BEGIN
    UPDATE productos
    SET precio_unitario = p_nuevo_precio
    WHERE cod_producto = p_cod_producto;


    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Producto no encontrado: ' || p_cod_producto);
    ELSE
        COMMIT; 
    END IF;
END;
/

```