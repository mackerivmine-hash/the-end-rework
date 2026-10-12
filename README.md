# End Plus (Fabric, Minecraft 26.3)

Mod que melhora o The End.

## Já tem
- **Ender Slime** (`endplus:ender_slime`): slime do End, nasce em todos os biomas do End.
- **Ender Dragon roxo**: textura nova sobrescrevendo a vanilla.

## Como rodar
Requer **JDK 25**.

1. Gere o wrapper (só na primeira vez), pois não vem o `gradlew`:
   - copie `gradlew`, `gradlew.bat` e `gradle/wrapper/gradle-wrapper.jar` do template em https://fabricmc.net/develop/template
   - ou, com o Gradle instalado: `gradle wrapper --gradle-version 9.7.1`
2. `./gradlew runClient` abre o jogo com o mod.
3. Dentro do jogo: `/summon endplus:ender_slime` ou vá ao The End.
4. `./gradlew build` gera o .jar em `build/libs/`.
